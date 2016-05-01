import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by David on 4/30/16.
 */
public class GraphNode implements Comparable<GraphNode>{
    public final static int NOT_NEIGHBOR = Integer.MAX_VALUE;
    private String name;
    private List<Neighbor> neighborList;


    /**
     * Represents a valid location in the game graph.
     * @param name
     */
    public GraphNode(String name){
            this.name = name;
    }



 /**
     * Return the name of this GraphNode.
     * @return
     */

    public String getNodeName(){
        return this.name;
    }
    /**
     * Returns a list of the neighbors of this GraphNode instance.
     * @return
     */
    public List<Neighbor> getNeighbors(){
        return this.neighborList;
    }

    /**
     * Returns true if this node name is a neighbor of current node.
     * @param neighborName
     * @return
     */
    public boolean	isNeighbor(String neighborName){
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
     * @param neighbor
     * @param cost
     */
    public void addNeighbor(GraphNode neighbor, int cost){
        Neighbor newNeighbor = new Neighbor(cost, neighbor);
        this.neighborList.add(newNeighbor);
        Collections.sort(this.neighborList);

        //Not sure if this is the correct way to sort!
    }

    /**
     * Returns an iterator that can be used to find neighbors of this GraphNode.
     * @return
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
     true if the GraphNode has a spycam
     * @return
     */
    public boolean	getSpycam(){

    }







    /**
     * @param name
     * @return
     */
    public GraphNode getNeighbor(String name){

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
