/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 06
 * Student ID       : .......................
 * Student Name     : .......................
 * Class            : ...
 * Cohort           : ...
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task1();
        task2();
    }

//    public static void task1() {
//        Game game = new Game();
//        game.startGame();
//    }

    public static void task2() {



                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Game Save System");
                    System.out.println("1. Save Game");
                    System.out.println("2. Load Game");
                    System.out.println("3. Count Items");
                    System.out.println("0. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter player name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter player health: ");
                            int health = scanner.nextInt();
                            System.out.print("Enter current level: ");
                            int level = scanner.nextInt();
                            System.out.print("Enter number of inventory items: ");
                            int numItems = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            String[] inventory = new String[numItems];
                            for (int i = 0; i < numItems; i++) {
                                System.out.print("Enter item " + (i + 1) + " (comma-separated if nested): ");
                                inventory[i] = scanner.nextLine();
                            }

                            Player player = new Player(name, health);
                            GameState gameState = new GameState(player, inventory, level);
                            GameSaveManager.saveGameState(gameState);
                            break;
                        case 2:
                            GameState loadedState = GameSaveManager.loadGameState();
                            if (loadedState != null) {
                                System.out.println("Game loaded:");
                                System.out.println("Player: " + loadedState.getPlayer().getName());
                                System.out.println("Health: " + loadedState.getPlayer().getHealth());
                                System.out.println("Level: " + loadedState.getCurrentLevel());
                                System.out.println("Inventory:");
                                for (String item : loadedState.getInventory()) {
                                    if (item != null) {
                                        System.out.println("- " + item);
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Loading game state to count items...");
                            GameState stateForCounting = GameSaveManager.loadGameState();
                            if (stateForCounting != null) {
                                int totalItems = GameSaveManager.countItems(stateForCounting);
                                System.out.println("Total items (including nested): " + totalItems);
                            }
                            break;
                        case 0:
                            System.out.println("Exiting.");
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }


        }


