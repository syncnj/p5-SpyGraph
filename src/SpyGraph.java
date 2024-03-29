///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// Files:            SpyGraph.java
// Semester:         CS367 Spring 2016
//
// Author:           Yi Shen
// Email:            yshen59@wisc.edu
// CS Login:         sheny
// Lecturer's Name:  James Skrentny
// Lab Section:      N/A
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     Yuchen Gu
// Email:            ygu48@wisc.edu
// CS Login:         yuchen
// Lecturer's Name:  James Skrentny
// Lab Section:      N/A
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Yifei Feng
//
//////////////////////////// 80 columns wide //////////////////////////////////



import java.util.*;
/**
 * Stores all vertexes as a list of GraphNodes.  Provides necessary graph operations as
 * need by the SpyGame class.
 * 
 * @author strominger
 *
 */
public class SpyGraph implements Iterable<GraphNode> {

    /** DO NOT EDIT -- USE THIS LIST TO STORE ALL GRAPHNODES */
    private List<GraphNode> vlist;


    /**
     * Initializes an empty list of GraphNode objects
     */
    public SpyGraph(){
        vlist = new ArrayList<>();
    }

    /**
     * Add a vertex with this label to the list of vertexes.
     * No duplicate vertex names are allowed.
     * @param name The name of the new GraphNode to create and add to the list.
     */
    public void addGraphNode(String name){
        if (name == null){
            throw new IllegalArgumentException("name is null");
        }
        Iterator<GraphNode> itr = this.iterator();
        while (itr.hasNext()){
            String itrName = itr.next().getNodeName();
            if (name.equals(itrName)){
                throw new IllegalArgumentException("duplicate node name is not allowed");
            }
        }
        GraphNode newNode = new GraphNode(name);
        vlist.add(newNode);
    }

    /**
     * Adds v2 as a neighbor of v1 and adds v1 as a neighbor of v2.
     * Also sets the cost for each neighbor pair.
     *   
     * @param v1name The name of the first vertex of this edge
     * @param v2name The name of second vertex of this edge
     * @param cost The cost of traveling to this edge
     * @throws IllegalArgumentException if the names are the same
     */
    public void addEdge(String v1name, String v2name, int cost) throws IllegalArgumentException{
        if (v1name==null || v2name== null || v1name.equals(v2name)){
            throw new IllegalArgumentException();
        }
        Iterator<GraphNode> itr = this.iterator();
        Boolean foundV1 = false;
        Boolean foundV2 = false;
        GraphNode v1Node = null;
        GraphNode v2Node = null;
        while(itr.hasNext() && (!foundV1 || !foundV2)){
            GraphNode itrNode  = itr.next();
            String itrName = itrNode.getNodeName();
            if (itrName.equals(v1name)){
                v1Node = itrNode;
                foundV1 = true;
            }
            if (itrName.equals(v2name)){
                v2Node = itrNode;
                foundV2 = true;

            }
        }

        if (v1Node== null || v2Node == null){
            throw new IllegalArgumentException("At least one name is not found");
        }
        v1Node.addNeighbor(v2Node, cost);
        v2Node.addNeighbor(v1Node, cost);


    }

    /**
     * Return an iterator through all nodes in the SpyGraph
     * @return iterator through all nodes in alphabetical order.
     */
    public Iterator<GraphNode> iterator() {
        return vlist.iterator();
    }

    /**
     * Return Breadth First Search list of nodes on path 
     * from one Node to another.
     * @param start First node in BFS traversal
     * @param end Last node (match node) in BFS traversal
     * @return The BFS traversal from start to end node.
     */
    public List<Neighbor> BFS( String start, String end ) {
        // may need and create a companion method
        if (start == null || end == null) {
            throw new IllegalArgumentException("Null input");
        }

        //Create the queue for nodes
        Queue<GraphNode> nodeQueue = new LinkedList<>();
        //Queue to store the path to the corresponding GraphNode
        Queue<List<Neighbor>> neighborQueue = new LinkedList<>();

        List<GraphNode> visitedList = new ArrayList<>();


        GraphNode startNode= this.getNodeFromName(start);
        GraphNode endNode = this.getNodeFromName(end);

        if (startNode== null || endNode==null){
            throw new IllegalArgumentException("start / end node couldn't be found");
        }
        visitedList.add(startNode);
        nodeQueue.add(startNode);
        neighborQueue.add(new ArrayList<>());
        return BFSHelper( nodeQueue, neighborQueue,  visitedList,  endNode);
   }
    /**
     * The recursive companion method for performing BFS.
     *
     * @param nodeQueue Current GraphNode to handle
     * @param neighborQueue the neighbor queue with corresponding path
     * @param visitedList store the visited list
     * @param endNode the destination node to find
     * @return the List with correct path, or Null if can't find a path
     */
    private List<Neighbor> BFSHelper ( Queue<GraphNode> nodeQueue,Queue<List<Neighbor>> neighborQueue,
                                      List<GraphNode> visitedList,
                                      GraphNode endNode ){
        if (nodeQueue.isEmpty()){
            return null;
        }
        GraphNode current = nodeQueue.remove();
        List<Neighbor> prevNeighborList = neighborQueue.remove();
        for(Neighbor neighbor: current.getNeighbors()){
            GraphNode newNode = neighbor.getNeighborNode();
            if (newNode.equals(endNode)){
                prevNeighborList.add(neighbor);
                return prevNeighborList;
            }
            else {
                if(!visitedList.contains(newNode)){
                    visitedList.add(newNode);
                    List<Neighbor> newList = new ArrayList<>(prevNeighborList);
                    newList.add(neighbor);
                    nodeQueue.add(newNode);
                    neighborQueue.add(newList);
                }
            }
        }
        List<Neighbor> resultList = BFSHelper(nodeQueue,neighborQueue, visitedList,endNode);
        if (resultList!=null){
            return resultList;
        }
        return null;



    }


    /**
     * @param name Name corresponding to node to be returned
     * @return GraphNode associated with name, null if no such node exists
     */
    public GraphNode getNodeFromName(String name){
        for ( GraphNode n : vlist ) {
            if (n.getNodeName().equalsIgnoreCase(name))
                return n;
        }
        return null;
    }

    /**
     * Return Depth First Search list of nodes on path 
     * from one Node to another.
     * @param start First node in DFS traversal
     * @param end Last node (match node) in DFS traversal
     * @return The DFS traversal from start to end node.
     */
    public List<Neighbor> DFS(String start, String end) {
        // may need and create a companion method
        if (start == null || end == null) {
            throw new IllegalArgumentException("Null input");
        }
        List<GraphNode> visitedList = new ArrayList<>();

        GraphNode startNode= this.getNodeFromName(start);
        GraphNode endNode = this.getNodeFromName(end);

        if (startNode== null || endNode==null){
            throw new IllegalArgumentException("start / end node couldn't be found");
        }
        visitedList.add(startNode);
        List<Neighbor> prevList = new ArrayList<>();
        return DFSHelper(prevList, visitedList, startNode, endNode);

    }

    /**
     * Companion method for DFS traverse using recursive
     * @param prevList the path from start point to currNode
     * @param visitedList all the nodes that have already been visited
     * @param currNode current Node to handle
     * @param endNode the destination node
     * @return The list from start node to end node
     */
    private List<Neighbor> DFSHelper (List<Neighbor> prevList, List<GraphNode> visitedList,
                                      GraphNode currNode, GraphNode endNode ){
        for(Neighbor neighbor: currNode.getNeighbors() ){
            if (neighbor.getNeighborNode().equals(endNode)){
                prevList.add(neighbor);
                return prevList;
            }
            if (!visitedList.contains(neighbor.getNeighborNode())){
                visitedList.add(neighbor.getNeighborNode());

                List<Neighbor> newList = new ArrayList<>(prevList);

                //Might produce error here
                newList.add(neighbor);
                List<Neighbor> returnList = DFSHelper(newList, visitedList, neighbor.getNeighborNode(), endNode);
                if (returnList!=null){
                    return returnList;
                }
            }
        }
        return null;
    }



    /**
     * OPTIONAL: Students are not required to implement Dijkstra's ALGORITHM
     *
     * Return Dijkstra's shortest path list of nodes on path 
     * from one Node to another.
     * @param start First node in path
     * @param end Last node (match node) in path
     * @return The shortest cost path from start to end node.
     */
    public List<Neighbor> Dijkstra(String start, String end){

        // TODO: implement Dijkstra's shortest path algorithm
        // may need and create a companion method
        // Return BFS traversal to prevent from Null Pointer
        return this.BFS(start, end);
    }


    /**
     * DO NOT EDIT THIS METHOD 
     * @return a random node from this graph
     */
    public GraphNode getRandomNode() {
        if (vlist.size() <= 0 ) {
            System.out.println("Must have nodes in the graph before randomly choosing one.");
            return null;
        }
        int randomNodeIndex = Game.RNG.nextInt(vlist.size());
        return vlist.get(randomNodeIndex);
    }


}
