/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 03
 * Student ID       : 5026231037
 * Student Name     : Al-khiqmah Manzilatul Mukaromah
 * Class            : D
 * Cohort           : F
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Do not change

        task1();
        task2();
        task3();
    }

    public static void task1(){
        System.out.println("===========================================");
        System.out.println("<b> Alpro Medical Diagnostic Centre</b>");
        System.out.println("-------------------------------------------");

        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your name : ");
        String name = sc.nextLine();

        System.out.print("Please input your sex ( m / f ) : ");
        String sex = sc.nextLine();

        System.out.print("Please input your height ( cm ) : ");
        int height = sc.nextInt();
        sc.nextLine();

        System.out.print("Please input your weight ( kg ) : ");
        int weight = sc.nextInt();
        sc.nextLine();

        //generating output
        System.out.println("-------------------------------------------");


        String salutation;
        if(sex.equals("m"))
        {
            salutation = "Mr";
        } else {
            salutation = "Ms";
        }

        //computing Body Mass Index (BMI)
        double heightInMeter = height/100.0;
        double bmi = weight /(heightInMeter*heightInMeter);
        String bmiCategory;

        // Based on https://www.siloamhospitals.com/en/informasi-siloam/artikel/cara-menghitung-bmi
        if(bmi < 18.5)
        {
            bmiCategory = "underweight";
        } else if (bmi>= 18.5 && bmi <= 24.9)
        {
            bmiCategory = "normal";
        } else if (bmi>= 25 && bmi <= 29.9)
        {
            bmiCategory = "overwight";
        } else {
            bmiCategory = "obese";
        }


        System.out.println("Customer Name\t: "+salutation + " " + name);
        System.out.println("BMI\t\t: "+ bmi);
        System.out.println("Category\t: <b><font color='b'>"+bmiCategory+"</b></font>");
        System.out.println("===========================================");

    }

    public static void task2(){
        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your Fullname \t: ");
        String fullName = sc.nextLine();
        System.out.print("Please input your student id \t: ");
        String studentId = sc.nextLine();

        //generating output
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("<b>Academic Report</b>");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("<b>Student ID.: " +studentId + "\t\t\t\t Fullname: "+ fullName);

        System.out.println("===============================================================================");
        System.out.println("<b>No.\tCode\tName\t\t\t\tCredit\tGrade\tScore\tW.Score</b>");

        //creating a variable of type Scanner
        Scanner scFile = new Scanner(Main.class.getResourceAsStream("transcript.csv"));
        //declare variable to read file per line
        String line;
        //declare array variable of String
        String [] lineSplit;

        //initialize varibles to store credits, total credits, and total to 0
        int credit = 0;
        int totalCredit = 0;
        double totalScore = 0.0;

        //declare and initialize the variables
        int no= 1;
        String code;
        String course;
        String grade;
        double score= 0.0;
        double wscore= 0.0;

        // read the file from beginning to the end

        while(scFile.hasNext()){
            //read the current line
            line = scFile.nextLine();;
            //split the current line by comma and save to an array variables
            lineSplit = line.split(",");

            code= lineSplit[0];
            course= lineSplit[1];
            credit = Integer.parseInt(lineSplit[2]);;
            grade= lineSplit[3];;

            //update the total credit by adding the current line credit
            totalCredit = totalCredit + credit;

            score= convertGradeToNumeric(grade);
            wscore= score*credit;
            //update the total score by adding the current line weighted score
            totalScore =  totalScore + wscore;

            //print out the current line
            System.out.println(no+"\t"+code +"\t"+ course+"\t\t"+credit+"\t"+grade+"\t"+score+"\t"+wscore);
            //update varible no by 1
            no++;


        }
        credit++;
        System.out.println("-------------------------------------------------------------------------------");

        double cgpa= totalScore/totalCredit;



        String category="";
        if (cgpa>=2.0)  category="passed";
        else category="failed";

        System.out.println("\t\t\t CGPA \t:<b>"+cgpa+" ("+category+")</b>");
        System.out.println("-------------------------------------------------------------------------------");

    }
    public static double convertGradeToNumeric(String grade){
        switch(grade){
            case "A":
                return 4.0;
            //complete the code here
            case "AB":
                return 3.5;
            //complete the code here
            case "B":
                return 3.0;
            //complete the code here
            case "BC":
                return 2.5;
            //complete the code here
            case "C":
                return 2.0;
            //complete the code here
            case "D":
                return 1.0;
            //complete the code here
            case "E":
                return 0.0;

        }
        return 0.0;
    }
    public static void task3(){ // mendefinisikan array untuk menangkap data pada masing-masing kompetisi

        // Essay
        String[] fieldOfCompetitionNew1 = new String[20];
        String[] teamName1 = new String[20];
        String[] teamLeader1 = new String[20];
        int[] score1 = new int[20];


        // data maining
        String[] fieldOfCompetitionNew2 = new String[20];
        String[] teamName2 = new String[20];
        String[] teamLeader2 = new String[20];
        int[] score2 = new int[20];

        // BPC
        String[] fieldOfCompetitionNew3 = new String[20];
        String[] teamName3 = new String[20];
        String[] teamLeader3 = new String[20];
        int[] score3 = new int[20];

        // Poster
        String[] fieldOfCompetitionNew4= new String[20];
        String[] teamName4 = new String[20];
        String[] teamLeader4 = new String[20];
        int[] score4 = new int[20];


        Scanner fileISE = new Scanner(Main.class.getResourceAsStream("ISEScoreRecapitulation.csv"));
        String line;
        String[] lineSplit;
        // mendefinisikan i untuk dijadikan array
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;


        System.out.println("\t\t\t\t ISE! ITS Golden Ticket Winning Team \t\t\t\t");
        System.out.println("=================================================================================================================");
        System.out.println("Field of Competition" + "\t\t\t Team Name" + "\t\t\tTeam Leader" + "\t\t Score");
        System.out.println("=================================================================================================================");
        while (fileISE.hasNext()) {
            line = fileISE.nextLine();
            lineSplit = line.split(",");

            // Memeriksa apakah lineSplit memiliki panjang yang sesuai
            if (lineSplit.length >= 5)
            {
                // menangkap nilai dan memasukan ke masing-masing erray berdasarkan jenis lomba
                if (lineSplit[1].equals("Essay")) {

                    fieldOfCompetitionNew1[a] = lineSplit[1];
                    teamName1[a] = lineSplit[2];
                    teamLeader1[a] = lineSplit[3];
                    score1[a] = Integer.parseInt(lineSplit[4]);
                    a = a + 1;
                }
                if (lineSplit[1].equals("Data Mining")) {
                    fieldOfCompetitionNew2[b] = lineSplit[1];
                    teamName2[b] = lineSplit[2];
                    teamLeader2[b] = lineSplit[3];
                    score2[b] = Integer.parseInt(lineSplit[4]);
                    b = b + 1;
                }
                if (lineSplit[1].equals("BPC")) {
                    fieldOfCompetitionNew3[c] = lineSplit[1];
                    teamName3[c] = lineSplit[2];
                    teamLeader3[c] = lineSplit[3];
                    score3[c] = Integer.parseInt(lineSplit[4]);
                    c = c + 1;
                }
                if (lineSplit[1].equals("Poster Infografis")) {
                    fieldOfCompetitionNew4[d] = lineSplit[1];
                    teamName4[d] = lineSplit[2];
                    teamLeader4[d] = lineSplit[3];
                    score4[d] = Integer.parseInt(lineSplit[4]);
                    d = d + 1;
                }
            }

        }
        fileISE.close();

        // 1, 2, 3
        // melakukan pencarian team yang memiliki skor tertinggi pada masing-masing kategori lomba

        // pencarian tim skor tertinggi untuk kategori lomba Essay
        String pemenangEssay = "";

        // Find index of greatest number
        int greatestIndex = 0;
        for (int i = 1; i < score1.length; i++) {
            if (score1[i] > score1[greatestIndex]) {
                greatestIndex = i;
            }



        }
        //mencetak nama tim dengan skor tertinggi essay
        System.out.println(fieldOfCompetitionNew1[greatestIndex].replaceAll("Essay", "Essay Competition") + "\t\t\t"+teamName1[greatestIndex] + "\t\t" +teamLeader1[greatestIndex]+ "\t\t "+score1[greatestIndex]);

        int greatestIndex2 = 0;
        for (int i = 1; i < score2.length; i++) {
            if (score2[i] > score2[greatestIndex2]) {
                greatestIndex2 = i;
            }



        }
        //mencetak nama tim dengan skor tertinggi
        System.out.println(fieldOfCompetitionNew2[greatestIndex2].replaceAll("Data Mining", "Data Mining Competition") + "\t\t\t"+teamName2[greatestIndex2] + "\t\t" +teamLeader2[greatestIndex2]+ "\t\t "+score2[greatestIndex2]);
        int greatestIndex3 = 0;
        for (int i = 1; i < score3.length; i++) {
            if (score3[i] > score3[greatestIndex3]) {
                greatestIndex3 = i;
            }



        }

        //mencetak nama tim dengan skor tertinggi
        System.out.println(fieldOfCompetitionNew3[greatestIndex3].replaceAll("BPC", "Business Plan Competition") + "\t\t"+teamName3[greatestIndex3] + "\t\t\t" +teamLeader3[greatestIndex3]+ "\t\t "+score3[greatestIndex3]);
        int greatestIndex4 = 0;
        for (int i = 1; i < score4.length; i++) {
            if (score4[i] > score4[greatestIndex4]) {
                greatestIndex4 = i;
            }



        }

        //mencetak nama tim dengan skor tertinggi
        System.out.println(fieldOfCompetitionNew4[greatestIndex4].replaceAll("Poster Infografis", "Infographic Poster Competition")  + "\t\t"+teamName4[greatestIndex4]+ "\t\t\t" +teamLeader4[greatestIndex4]+ "\t\t "+score4[greatestIndex4]);


    }
}
