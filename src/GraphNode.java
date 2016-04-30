/**
 * Created by David on 4/30/16.
 */
public class GraphNode {
    public static int NOT_NEIGHBOR;

    /**
     * Represents a valid location in the game graph.
     * @param name
     */
    public GraphNode(String name){

    }

    /**
     * Maintains sorted order of neighbors by neighbor name.
     * @param neighbor
     * @param cost
     */
    public void addNeighbor(GraphNode neighbor, int cost){

    }

    /**
     * Return the results of comparing this node's name to the other node's name.
     * @param otherNode
     * @return
     */
    public int	compareTo(GraphNode otherNode){
        return 0;
    }

    /**
     * Prints a list of neighbors of this GraphNode and the cost of the edge to them
     */
    public void	displayCostToEachNeighbor(){

    }

    /**
     *
     * @param neighborName
     * @return
     */

    public int	getCostTo(java.lang.String neighborName){

    }

    /**
     *
     * @param name
     * @return
     */
    public GraphNode getNeighbor(String name){

    }

    /**
     * Returns an iterator that can be used to find neighbors of this GraphNode.
     * @return
     */

    public Iterator<String>	getNeighborNames(){

    }

    /**
     * Returns a list of the neighbors of this GraphNode instance.
     * @return
     */
    public List<Neighbor>	getNeighbors(){

    }

    /**
     * Return the name of this GraphNode.
     * @return
     */

    public String getNodeName(){

    }

    public boolean	getSpycam(){

    }

    /**
     * Returns true if this node name is a neighbor of current node.
     * @param neighborName
     * @return
     */
    public boolean	isNeighbor(String neighborName){
        return false;
    }

    /**
     *  Display's the node name followed by a list of neighbors to this node.
     */

    public void	printNeighborNames(){

    }

    /**
     *
     * @param cam
     */

    public void	setSpycam(boolean cam){

    }

    public String	toString(){

    }

}
