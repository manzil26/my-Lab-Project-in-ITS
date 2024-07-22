import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 06
 * Student ID       : Al-khiqmah Manzilatul Mukaromah
 * Student Name     : 5026231037
 * Class            : D
 * Cohort           : 4/D
 */

public class Main {
    public static void main(String[] args) {

        task1();
        task2();
    }

    public static void task1() {
        Game game = new Game();
        game.startGame();
    }

    public static void task2() {

        Pos pos = new Pos();
        try (BufferedReader br = new BufferedReader(new FileReader("Root/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    pos.add(parts[0], parts[1], parts[2], parts[3]);
                } else {
                    System.out.println("Invalid record format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        int[] denominations = {100000, 50000, 20000, 10000, 5000, 2000, 1000};
        for (int i = 0; i < pos.getLength(); i++) {
            Record record = pos.getRecord(i);
            System.out.println("Buyer's name    : " + record.getName());
            System.out.println("Payment date    : " + record.getDate());
            System.out.println("Amount Owed     : " + record.getAmountOwed());
            System.out.println("Amount Paid     : " + record.getAmountPayed());
            System.out.println("Change          : " + record.getChange());
            System.out.println("Change Details  :");
            System.out.println("====================================");
            System.out.println("Denominations\t|\tQuantity");
            System.out.println("====================================");
            pos.change(record.getChange(), denominations, 0);
            System.out.println();
        }
    }
}


