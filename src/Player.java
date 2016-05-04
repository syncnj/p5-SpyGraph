///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Game.java
// Files:            Player.java
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



import java.util.ArrayList;
import java.util.List;




public class Player {


    private String name;
    private int budget = 0;
    private int spycams = 0;
    private GraphNode currentNode;
    private List<GraphNode> spyCamDrop = new ArrayList<>();


   public Player(String name, int budget, int spycams, GraphNode startnode){
       if (name == null || startnode == null || budget <0 || spycams <0){
           throw new IllegalArgumentException();
       }

       this.name=name;
       this.budget = budget;
       this.spycams = spycams;
       this.currentNode = startnode;

   }


    public String getName(){
        return this.name;
    }

    public int getBudget(){
        return this.budget;
    }

    public void decreaseBudget(int dec){
            this.budget -= dec;
    }

    /**
     *
     * @return true if a spycam is dropped
     */
    public boolean dropSpycam(){
        if (this.spycams == 0){
            System.out.println("Not enough spycams");
            return false;
        }
        else{
            if (!this.getLocation().getSpycam()){
                this.getLocation().setSpycam(true);
                this.spycams--;
                spyCamDrop.add(this.getLocation());
                System.out.print("Dropped a Spy Cam at " + this.getLocationName()+"\n");
                return true;
            }
            System.out.println("Already a Spy Cam there");
            return false;
        }

    }

    public boolean pickupSpycam(GraphNode node){
        if (node == null){
            throw new IllegalArgumentException("node can't be null");
        }
        if (node.getSpycam()){
            node.setSpycam(false);
            spyCamDrop.remove(node);
            this.getSpycamBack(true);  //should it be here? The other get spycams back is never called!!!!!!!
            return true;

            // !!!!!!!!!!!
        }
        return false;
    }

    public int getSpycams(){
        return this.spycams;
    }

    public boolean move(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        if (this.currentNode.isNeighbor(name)) {
            for (Neighbor neighbor : this.currentNode.getNeighbors()) {
                if (neighbor.getNeighborNode().getNodeName().equals(name)) {
                    if (this.budget - neighbor.getCost() >= 1) {
                        if (neighbor.getCost() > 1) {
                            this.budget -= neighbor.getCost();
                        }

                        this.currentNode = neighbor.getNeighborNode();
                        return true;
                    }
                    System.out.print("Not enough money cost is "+ neighbor.getCost() +  " budget is "+ this.budget+ "\n");
                }

            }


        }
        else{
            System.out.println(name + " is not a neighbor of your current location");
        }
        return false;
    }

    public String getLocationName(){
        return this.currentNode.getNodeName();
    }


    public GraphNode getLocation(){
        return this.currentNode;

    }

    public void getSpycamBack(boolean pickupSpyCam){
        if (pickupSpyCam ){
            this.spycams++;
        }
    }





    public void printSpyCamLocations(){
        for (GraphNode currentNode: this.spyCamDrop){
            System.out.println ("Spy cam at "+ currentNode.getNodeName());
        }
    }


}

