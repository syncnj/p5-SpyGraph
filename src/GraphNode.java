import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class GraphNode implements Comparable<GraphNode>{
    private final static int NOT_NEIGHBOR = Integer.MAX_VALUE;
    private String name;
    private List<Neighbor> neighborList = new ArrayList<>();
    private Boolean hasSpycam = false;


    /**
     * Represents a valid location in the game graph.
     * @param name  The label that uniquely identifies this graph node.
     */
    public GraphNode(String name){
            this.name = name;
    }



 /**
     * Return the name of this GraphNode.
     * @return name of node
  */

    public String getNodeName(){
        return this.name;
    }



    /**
     * Returns a list of the neighbors of this GraphNode instance. This instance of GraphNode is not included as it is not a neighbor of itself.
     * @return a list of neighbors of this GraphNode.
     */
    public List<Neighbor> getNeighbors(){
        return this.neighborList;
    }

    /**
     * Returns true if this node name is a neighbor of current node.
     * @param neighborName to look for
     * @return true if the node is an adjacent neighbor.
     */
    public boolean	isNeighbor(String neighborName){
        if (neighborName == null){
            throw new IllegalArgumentException();
        }

        Iterator<Neighbor> itr = this.neighborList.iterator();

        while (itr.hasNext()) {
            String itrName = itr.next().getNeighborNode().getNodeName();
            if (neighborName.equals(itrName)){
                return true;
            }
        }
        return false;
    }

    /**
     * Maintains sorted order of neighbors by neighbor name.
     * @param neighbor An adjacent node (a neighbor)
     * @param cost The cost to move to that node (from this node)
     */
    public void addNeighbor(GraphNode neighbor, int cost){
        if (neighbor== null || cost <0){
            throw new IllegalArgumentException();
        }
        Neighbor newNeighbor = new Neighbor(cost, neighbor);
        this.neighborList.add(newNeighbor);
        Collections.sort(this.neighborList);

        //Not sure if this is the correct way to sort!
    }

    /**
     * Returns an iterator that can be used to find neighbors of this GraphNode.
     * @return An iterator of String node labels
     */

    public Iterator<String>	getNeighborNames(){
        List <String> neighborNameList = new ArrayList<>();
        Iterator<Neighbor> itr = this.neighborList.iterator();
        while (itr.hasNext()){
            neighborNameList.add(itr.next().getNeighborNode().getNodeName());
        }

        return neighborNameList.iterator();
    }

    /**
     * @return  true if the GraphNode has a spycam
     */
    public boolean getSpycam(){
        return this.hasSpycam;
    }

    /**
     *
     * @param cam indicates whether the node now has a spycam
     */

    public void	setSpycam(boolean cam){
        this.hasSpycam = cam;
    }

    /**
     *
     * @param neighborName name of potential neighbor
     * @return cost to neighborName
     * @throws NotNeighborException - if neighborName is not a neighbor
     */
    public int	getCostTo(String neighborName) throws NotNeighborException {
        if (neighborName == null){
            throw new IllegalArgumentException();
        }
        for (Neighbor neighbor:this.neighborList){
            if (neighbor.getNeighborNode().getNodeName().equals(neighborName)){
                return neighbor.getCost();
            }
        }
        throw new NotNeighborException();

    }

    /**
     * @param name name of potential neighbor
     * @return the GraphNode associated with name that is a neighbor of the current node
     * @throws NotNeighborException - if name is not a neighbor of the GraphNode
     */
    public GraphNode getNeighbor(String name) throws NotNeighborException {
        if (name == null){
            throw new IllegalArgumentException();
        }
        for (Neighbor neighbor:this.neighborList){
            if (neighbor.getNeighborNode().getNodeName().equals(name)){
                return neighbor.getNeighborNode();
            }
        }
        throw new NotNeighborException();

    }

    /**
     * Prints a list of neighbors of this GraphNode and the cost of the edge to them
     */
    public void	displayCostToEachNeighbor(){
        for (Neighbor neighbor: this.neighborList){
            System.out.println(neighbor.getCost() + " " + neighbor.getNeighborNode().getNodeName());
        }
    }

    /**
     * Return the results of comparing this node's name to the other node's name.
     * @param otherNode Another node to compare names with this node.
     * @return the result of compareTo on the node names only.
     */
    public int	compareTo(GraphNode otherNode){
        return this.getNodeName().compareTo(otherNode.getNodeName());
    }


    /**
     * @return name of node
     */

    public String toString(){
        return this.getNodeName();
    }

    /**
     *  Display's the node name followed by a list of neighbors to this node.
     */

    public void	printNeighborNames(){
        this.displayCostToEachNeighbor();
    }


}
