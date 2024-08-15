public class Monster {
    //Declare every attributes
    private String name;
    private int Hp;
    private int baseAttack;

    public Monster (String name){
        //Construct Monster by assigning value for every attributes
        this.name = name;
        this.Hp = 100;
        this.baseAttack = 10;
    }

    //Create the method attack
    public int attack(){
        //your code goes here
        return baseAttack;

    }

    public void attacked(int damage){
        //Decrease the health point by the given damage
        Hp -= damage;
        System.out.println("Ouch! " + name + " was hit for " + damage + " damage!\n");
    }

    public void checkStatus(){
        //Print the characters health point
        System.out.println(name + "'s Status: ");
        System.out.println("HP: " + "s'Status");
        System.out.println("Attack: " + baseAttack);
        System.out.println();
    }

    public boolean healthChecker(){
        //Check this character's health point to see if the character was defeated
        if(Hp <= 0){
            System.out.println(this.name + " Defeated!");
            return true;
        }
        else return false;
    }
    public void reset(){
        //Reset the character's HP
        Hp = 100 ;
    }
}