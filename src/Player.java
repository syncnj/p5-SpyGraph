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
    private GraphNode startnode;

   public Player(String name, int budget, int spycams, GraphNode startnode){



   }

    public void decreaseBudget(int dec){

    }

    public boolean dropSpycam(){
        return false;
    }
    public int getBudget(){
        return this.budget;
    }
    public GraphNode getLocation(){

    }
    public String getLocationName(){
        return null;
    }
    public String getName(){
        return this.name;
    }
    public int getSpycamBack(boolean pickupSpyCam){
        return -0;
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
    public void printSpyCamLocations(){

    }






}

