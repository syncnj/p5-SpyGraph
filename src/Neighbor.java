/**
 * Created by yblur on 4/28/2016.
 */
public class Neighbor {
    private int cost;
    private GraphNode neighbor;

    /**
     * A neighbor is added to an existing GraphNode by creating an instance of Neighbor that stores the neighbor and the cost to reach that neighbor.
     * @param cost  The cost to reach this neighbor.
     * @param neighbor The neighbor node being reached by this edge.
     */
    public Neighbor(int cost, GraphNode neighbor){
        this.cost = cost;
        this.neighbor = neighbor;

    }

    /**
     * Compares the node names of this node and the otherNode.
     * @param otherNode
     * @return
     */
    public int compareTo(Neighbor otherNode){
        int result = this.neighbor.getNodeName().compareTo(otherNode.)
        if (result > 0 ){
            return 1;
        }
        else if (result < 0 ){
            return -1;

        }
        else {
            return 0;
        }
    }

    /**
     *
     * @return Returns the cost of travelling this edge to get to the Neighbor at the other end of this edge.
     */
    public int getCost(){
        return this.cost;
    }

    /**
     *
     * @return  Returns the Neighbor (node) that is at the other end of "this" node's edge.
     */
    public GraphNode getNeighborNode(){
        return neighbor;

    }

    /**
     *
     * @return Returns a String representation of this Neighbor.
     */
    public String toString(){
        return "--" + this.cost + "--> "+ this.getNeighborNode().getNodeName();

    }
}
