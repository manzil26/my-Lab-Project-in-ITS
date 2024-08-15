public class GameState {
    //your code goes here
    private Player player;

    private  String [] inventory;
    private int CurrentLevel;

    public GameState(Player player, String [] inventory, int CurrentLevel){
        this.player = player;
        this.inventory = inventory;
        this.CurrentLevel = CurrentLevel;

    }

    public Player getPlayer() {
        return player;
    }
    public String[] getInventory() {
        return inventory;
    }
    public int getCurrentLevel(){
        return  CurrentLevel;
    }

}