import java.io.*;
import java.util.Scanner;

public class Game {

    private Scanner read = new Scanner(System.in);
    private int moves = 0;
    private Human hooman;
    private Monster monstah;


    public void startGame(){
        System.out.println("Welcome to Borneo Rail Impact 2nd");

        //Ask to input the name for both human and monster
        String name;
        System.out.print("Input Human's Name: ");
        name = read.nextLine();
        hooman = new Human(name);
        System.out.print("Input Monster's Name: ");
        name = read.nextLine();
        monstah = new Monster(name);
        System.out.println();

        //Display human and monster's stat
        hooman.checkStatus();
        monstah.checkStatus();

        //Start a round 3 times
        for(int i = 1; i < 4; i++){
            System.out.println();
            System.out.println("Round " + i + " start!");
            roundStart(i);
        }

        System.out.println("Game over!");

    }

    public void roundStart(int round){
        //Amount of moves need to be restarted every round
        moves = 0;

        //Call a method to start a turn
        turnStart();

        //Reset both character's HP using a method
        hooman.reset();
        monstah.reset();

        //Create file to keep track of round's results using a method
        roundRecord(round);
    }

    public void turnStart(){
        int choice;
        boolean run = false;

        //Check if it's human's turn or monster's turn and print a sentence declaring it.
        if(moves % 2 == 0) System.out.println("Player's Turn!");
        else System.out.println("Monster's Turn!");

        //Display menu of choices
        displayMenu();

        //Take input of choice
        choice = read.nextInt();

        //Make if-else for each choices that can be made (According to turnMenu.txt)
        if(choice == 1){
            if(moves % 2 == 0){
                monstah.attacked(hooman.attack());
            }
            else hooman.attacked(monstah.attack());
            moves++;
        } else if (choice == 2){
            if(moves % 2 == 0) hooman.checkStatus();
            else monstah.checkStatus();
        } else if(choice == 3){
            System.out.println("Aight, nothin...");
            System.out.println();
            moves++;
        } else {
            System.out.println("Don't dare to run you coward!");
            run = true;
        }

        //Make an if-else condition to check wether the one of the character has chosen to run (exit) or one of the character has died.
        if(!run){
            if(!aliveChecker()){
                //Call this method itself to do a recursive repeating the turn
                turnStart();
            }
        } else {
            System.out.println("\nRound Over!\n");
        }
    }

    public boolean aliveChecker(){
        //Check the condition of both human and monster, return a true value if either the human or monster is dead
        if(monstah.healthChecker() || hooman.healthChecker()) return true;
        else return false;
    }

    public void roundRecord(int round){
        String outputFile = "Root/output.txt";
        try{
            //Declare a FileWriter type variable to write on a file and assign a file path (Set append to true so we can keep writing on the same file)
            FileWriter fileWriter = new FileWriter(outputFile, true);

            //Write on the designated file about the round's record
            fileWriter.write("Round " + round + " Record\n");
            fileWriter.write("Moves taken : " + moves + "\n");

            //Identify who is the winner by checking who does the last turn on that round.
            String winner;
            if(hooman.healthChecker()) winner = "Monster";
            else winner = "Human";

            //Write about who is the winner
            fileWriter.write("Winner : " + winner + "\n");
            fileWriter.write("\n");

            //Close the fileWriter
            fileWriter.close();
        } catch(IOException e) {
            System.out.println("An error occurred while writing the file.");
            System.out.println(e);
        }
    }

    private static void displayMenu(){
        BufferedReader bufferedReader = null;
        try {
            // Initialize FileReader and BufferedReader
            FileReader fileReader = new FileReader("Root/turnMenu.txt");
            bufferedReader = new BufferedReader(fileReader);

            String line;

            //Keep printing the contents in the file until there is no more contents
            while ((line = bufferedReader.readLine()) != null) {
                // Print each line to the console
                System.out.println(line);
            }

            //Close both fileReader and bufferedReader
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            // Handle IOException
            System.out.println("An error occurred while reading the file.");
            System.out.println(e);
        }
    }
}