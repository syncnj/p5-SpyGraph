


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
        // TODO initialize data member(s)
        vlist = new ArrayList<>();
    }

    /**
     * Add a vertex with this label to the list of vertexes.
     * No duplicate vertex names are allowed.
     * @param name The name of the new GraphNode to create and add to the list.
     */
    public void addGraphNode(String name){
        // TODO implement this method
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
        // TODO implement this method
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
        // TODO implement this method
        // may need and create a companion method
        if (start == null || end == null) {
            throw new IllegalArgumentException("Null input");
        }
        List<Neighbor> returnList = new ArrayList<>();
        Queue<Neighbor> queue = new LinkedList<>();
        List

        Iterator<GraphNode> itr = this.iterator();
        Boolean foundStart= false;
        Boolean foundEnd = false;
        GraphNode startNode= null;
        GraphNode endNode = null;
        while(itr.hasNext() && (!foundStart || !foundEnd)){
            GraphNode itrNode  = itr.next();
            String itrName = itrNode.getNodeName();
            if (itrName.equals(start)){
                startNode = itrNode;
                foundStart = true;
            }
            if (itrName.equals(end)){
                endNode = itrNode;
                foundEnd = true;

            }
        }



        returnList.add();


        return returnList;
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
         // TODO implement this method
         // may need and create a companion method

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
        
        return null;
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
