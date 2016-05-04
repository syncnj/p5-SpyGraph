///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// Files:            Neighbor.java
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
public class Neighbor implements Comparable<Neighbor>{


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
     * @param otherNode neighbor to be compared
     * @return compareTo the node names of two neighbors
     */
    public int compareTo(Neighbor otherNode){
        int result = this.neighbor.getNodeName().compareTo(otherNode.getNeighborNode().getNodeName());
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
        return this.neighbor;

    }


    /**
     *
     * @return Returns a String representation of this Neighbor.
     */
    public String toString(){
        return "--" + this.cost + "--> "+ this.getNeighborNode().getNodeName();

    }
}
