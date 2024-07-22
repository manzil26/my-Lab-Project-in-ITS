/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 05
 * Student ID       : 5026231037
 * Student Name     : Al-khiqmah Manzilatul Mukaromah
 * Class            : D
 * Cohort           : D/4
 */
import java.util.Scanner;
import java.lang.*;

public class Main {


    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    static void task1(){

        //read the file
        Scanner sc = new Scanner(Main.class.getResourceAsStream("matrix.txt"));
        //get the number of matrix
        int nm = sc.nextInt();

        //loop for each matrix
        for(int i=0;i<nm;i++){
            //read the number of row and colomn;
            int row = sc.nextInt();
            int column = sc.nextInt();

            //declare the original matrix
            int [][] matrix = new int[row][column];
            //declare the transpose matrix
            int [][] transposeMatrix = new int[column][row];

            //declare varible to hold the number/temp
            int val;

            //assign the number into the 2D matrix
            for(int j=0;j<row;j++){
                for(int k=0;k<column;k++){
                    val = sc.nextInt(); // masih baca input
                    matrix[j][k] = val; // val holds the value of 0,0 in iteration 1
                    transposeMatrix[k][j] = val;
                }
            }

            // Print the original matrix
            System.out.println("M:");
            for(int k=0;k<row;k++){
                for(int j=0;j<column;j++){
                    System.out.print(matrix[k][j] + "\t");
                }
                System.out.println();
            }

            // Print the tranpose matrix
            System.out.println("M':");
            for(int j=0;j<column;j++){
                for(int k=0;k<row;k++){
                    System.out.print(transposeMatrix[j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    static void task2(){
        //read the input file and the number of test case
        // queen = 1, pawn = 2
        Scanner sc = new Scanner(Main.class.getResourceAsStream("board.txt"));
        int t = sc.nextInt();
        // declare var position
        int yPosQueen = 0;
        int xPosQueen = 0;
        int yPosPawn = 0;
        int xPosPawn = 0;
        // declare matrix board
        int[][] board = new int[8][8];
        //loop for each test case
        for(int n=0;n<t;n++){

            //decalre the needed variable
            yPosQueen = 0;
            xPosQueen = 0;
            yPosPawn = 0;
            xPosPawn = 0;
            board = new int[8][8];


            //loop to assign the number into 2D array and find the position of queen and Pawn
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    //your code goes here
                    board[i][j] = sc.nextInt();
                    // find position of queen
                    if(board[i][j] == 1){
                        yPosQueen = i;
                        xPosQueen = j;
                    } else if(board[i][j] == 2){
                        yPosPawn = i;
                        xPosPawn = j;
                    }
                }
            }



            //decalare any required variables here
            boolean isThreatened = false;
            boolean isOneRow = false;
            boolean isOneCol = false;
            boolean isDiagonal = false;
            int minCol = 0;
            int maxCol = 0;
            int minRow = 0;
            int maxRow = 0;
            //check whether the pawn is threatened or not

            // satu kolom?
            if(xPosQueen == xPosPawn){
                isThreatened = true;
                isOneCol = true;
                if(yPosPawn > yPosQueen){
                    minRow = yPosQueen;
                    maxRow = yPosPawn;
                } else{
                    minRow = yPosPawn;
                    maxRow = yPosQueen;
                }
            } else if(yPosQueen == yPosPawn){ // satu baris?
                isThreatened = true;
                isOneRow = true;
                if(xPosPawn > xPosQueen){
                    minCol = xPosQueen;
                    maxCol = xPosPawn;
                } else {
                    minCol = xPosPawn;
                    maxCol = xPosQueen;
                }
            } else if(Math.abs(yPosPawn - yPosQueen) == Math.abs(xPosPawn - xPosQueen)){ // satu diagonal?
                isThreatened = true;
                isDiagonal = true;
                if(xPosPawn > xPosQueen){
                    minCol = xPosQueen;
                    maxCol = xPosPawn;
                } else{
                    minCol = xPosPawn;
                    maxCol = xPosQueen;
                }

                if(yPosPawn > yPosQueen){
                    minRow = yPosQueen;
                    maxRow = yPosPawn;
                } else {
                    minRow = yPosPawn;
                    maxRow = yPosQueen;
                }
            }


            //your code here
            //print the chess board if the pawn is threatened by the queen
            if (isThreatened){
                System.out.println("YES");
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        //your code goes here
                        if (board[i][j] == 1){
                            System.out.print("Q" + "\t");
                        } else if (board[i][j] == 2){
                            System.out.print("P" + "\t");
                        } else {
                            if(isOneCol && j == xPosQueen && i>minRow && i<maxRow){
                                System.out.print("X" + "\t");
                            } else if (isOneRow && i == yPosQueen && j>minCol && j<maxCol){
                                System.out.print("X" + "\t");
                            } else if (isDiagonal && i >minRow && i<maxRow && j>minCol && j<maxCol && Math.abs(i - yPosQueen) == Math.abs(j - xPosQueen)){
                                System.out.print("X" + "\t");
                            } else {
                                System.out.print("0" +"\t");
                            }
                        }
                    }
                    //your code goes here
                    System.out.println();
                }

            } else {
                System.out.println("NO");
            }

        }

    }



    static void task3() {
        // your code goes here
        Scanner scn = new Scanner(Main.class.getResourceAsStream("bingo.txt"));
        int testCase = scn.nextInt();
        int numberCard;
        int[][] arrayBoard = new int[5][5];

        for (int i = 0; i < testCase; i++) {
            int amountOfCard = scn.nextInt();
            int[] arrayNumberCard = new int[amountOfCard];

            for (int j = 0; j < amountOfCard; j++) {
                numberCard = scn.nextInt();

                arrayNumberCard[j] = numberCard;
            }

            System.out.println(" ");

            for (int k = 0; k < 5; k++) {
                for (int j = 0; j < 5; j++) {
                    arrayBoard[k][j] = scn.nextInt();
                }
            }

            // insialisasi win jadi false

            boolean win = false;

            // Cek setiap baris
            if (!win) {
                for (int k = 0; k < 5; k++) {
                    int matchCount = 0;
                    for (int j = 0; j < 5; j++) {
                        for (int n : arrayNumberCard) {
                            if (arrayBoard[k][j] == n) {
                                matchCount++;

                                break;
                            }
                        }
                    }

                    if (matchCount == 5) {
                        win = true;
                        break;
                    }
                }
            }

            // Cek setiap kolom
            if (!win) {
                for (int j = 0; j < 5; j++) {
                    int matchCount = 0;
                    for (int k = 0; k < 5; k++) {
                        for (int n : arrayNumberCard) {
                            if (arrayBoard[k][j] == n) {
                                matchCount++;
                                break;
                            }
                        }
                    }
                    if (matchCount == 5) {
                        win = true;
                        break;
                    }
                }
            }

            // Cek diagonal utama
            if (!win) {
                int matchCount = 0;
                for (int j = 0; j < 5; j++) {
                    for (int n : arrayNumberCard) {
                        if (arrayBoard[j][j] == n) {
                            matchCount++;
                            break;
                        }
                    }
                }
                if (matchCount == 5) {
                    win = true;
                }
            }

            // Cek diagonal sekunder
            if (!win) {
                int matchCount = 0;
                for (int j = 0; j < 5; j++) {
                    for (int n : arrayNumberCard) {
                        if (arrayBoard[j][4 - j] == n) {
                            matchCount++;
                            break;
                        }
                    }
                }
                if (matchCount == 5) {
                    win = true;
                }
            }

            // Print hasil
            if (win) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }
        }
    }
}
