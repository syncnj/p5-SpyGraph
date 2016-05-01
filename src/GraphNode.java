import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by David on 4/30/16.
 */
public class GraphNode implements Comparable<GraphNode>{
    private final static int NOT_NEIGHBOR = Integer.MAX_VALUE;
    private String name;
    private List<Neighbor> neighborList;
    private Boolean hasSpycam = false;


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
     * @param neighbor
     * @param cost
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
     *  Display's the node name followed by a list of neighbors to this node.
     */

    public void	printNeighborNames(){

    }



    public String	toString(){

    }

}
