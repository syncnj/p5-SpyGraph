import java.util.Iterator;
import java.util.List;

/**
 * Created by yblur on 4/28/2016.
 */


public class Player {

    /**
     *
     * @param name
     * @param budget
     * @param spycams
     * @param startnode
     */
    private String name;
    private int budget = 0;
    private int spycams = 0;
    private GraphNode currentNode;
    private List<GraphNode> spyCamDrop ;


   public Player(String name, int budget, int spycams, GraphNode startnode){
       if (name == null || startnode == null){
           throw new IllegalArgumentException();
       }

            this.name=name;
            this.budget = budget;
            this.spycams = spycams;
            this.currentNode = startnode;

   }

    public void decreaseBudget(int dec){
            this.budget = this.budget - dec;

    }

    /**
     *
     * @return true if a spycam is dropped
     */
    public boolean dropSpycam(){
        if (this.spycams == 0){
            System.out.print("Not enough spycams");
            return false;
        }
        else{
            if (!this.getLocation().getSpycam()){
                this.getLocation().setSpycam(true);
                this.spycams--;
                spyCamDrop.add(this.getLocation());
                return true;

            }
            return false;
        }

    }
    public int getBudget(){
        return this.budget;
    }
    public GraphNode getLocation(){
        return currentNode;

    }
    public String getLocationName(){
        return this.currentNode.getNodeName();
    }
    public String getName(){
        return this.name;
    }


    public void getSpycamBack(boolean pickupSpyCam){
        if (pickupSpyCam ){
            this.spycams++;
        }
    }

    public int getSpycams(){
        return this.spycams;
    }
    public boolean move(String name){
        if (name == null){
            throw new IllegalArgumentException("name is null");
        }
        return false;
    }
    public boolean pickupSpycam(GraphNode node){
        if (node == null){
            throw new IllegalArgumentException("node can't be null");
        }
        return false;
    }

    /**
     *
     * @return spycam list's iterator
     */
    public Iterator<GraphNode> iteratorspyCam() {

        return spyCamDrop.iterator();
    }
    public void printSpyCamLocations(){
        while(iteratorspyCam().hasNext()){
            System.out.print(iteratorspyCam().next());
        }

    }






}

