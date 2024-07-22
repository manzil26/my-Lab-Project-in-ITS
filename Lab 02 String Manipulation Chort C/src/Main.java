/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 02
 * Student ID       : 5026231037
 * Student Name     : Al-khiqmah Manzilatul Mukaromah
 * Class            : D
 * Cohort           : C
 */

public class Main {

    public static void main(String[] args) {
        // Do not change

        task1("Rahman Arif/17-02-2003/Jakarta/M/A/WNI/Single");
        task1("Alice Rebecca/17-03-1984/London/F/O/WNA/Married");
        task2("Wanda");
        task3();
        task4("three+two");
        task4("ten+two");
    }


    public static String task1(String data){

        // Your code here
        // ...

        int startPosition = 0;
        //find the first slash position within string stored in variable named data
        int slashPosition = data.indexOf("/");
        //chop the string from the beginning to the first slash position (/ is excluded)
        String name = data.substring(startPosition, slashPosition);
        //split and reverse the name to correct firstname and lastname order
        String firstName= name.substring(name.indexOf(" ")+1,slashPosition);
        String lastName= name.substring(startPosition, name.indexOf(" "));
        //get the first character of first and last name
        String initial = ""+ firstName.charAt(0)+ lastName.charAt(0);

        //chop the string stored in variable named data from the first slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the date of birth dd-mm-yyyy
        String birthDate = data.substring(startPosition,slashPosition);
        //chop the year of birth yyyy
        String birthYear = data.substring(6,10);
        //count the age 
        int age = 2023 - (Integer.parseInt(birthYear));

        //chop the string stored in variable named data from the second slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the palce of birth
        String birthPlace =data.substring(startPosition, slashPosition);

        //chop the string stored in variable named data from the third slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the sex data M or F
        String sex = data.substring(startPosition, slashPosition);
        //change M to Male and F to Female
        sex= sex.replace("F","Female");
        sex = sex.replace("M", "Male");

        //chop the string stored in variable named data from the fourth slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the blood type data
        String bloodType = data.substring(startPosition, slashPosition);

        //chop the string stored in variable named data from the fifth slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the citizenship data
        String citizen = data.substring(startPosition, slashPosition);
        //check whether local citizen
        boolean isLocalCitizenB = citizen.equals("WNI");
        //change true or false to Yes or No
        String isLocalCitizen =""+isLocalCitizenB;
        isLocalCitizen = isLocalCitizen.replace("true","Yes");
        isLocalCitizen = isLocalCitizen.replace("false","No");

        //chop the string stored in variable named data from the sixth slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //chop the marital status data
        String maritalStatus = data;

        //generating the output
        String line1 = "Full Name: " + firstName + " "+lastName+ " (" + initial + ")";
        String line2 = "Age: " + age;
        String line3 = "City of Birth: " + birthPlace;
        String line4 = "Sex: " + sex;
        String line5 = "Blood Type: " + bloodType;
        String line6 = "Local Citizine: " + isLocalCitizen;
        String line7 = "Marital Status: " + maritalStatus;

        //store the output to variable named output
        String output = line1 + "\n" + line2+ "\n" + line3+ "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n" + line7 + "\n";

        //print out the output
        System.out.println(output);

        return output;


    }

    public static String task2(String name){

        // Your code here
        // ...

        //store all alphabet to single string
        //each alphabet with its index: a -> 0, b->1. ... z ->25
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        //change the input to lowercase, since tha alphabets are all in lowercase
        String name1 = name.toLowerCase();

        //set the key

        int key = 5;

        //shift each character to 5 places right, if more than 25 then it back to 0
        String k1 = ""+alphabet.charAt((alphabet.indexOf(name.charAt(0)) + key) % 26);
        String k2 = ""+alphabet.charAt((alphabet.indexOf(name.charAt(1)) + key) % 26);
        String k3 = ""+alphabet.charAt((alphabet.indexOf(name.charAt(2)) + key) % 26);
        String k4 = ""+alphabet.charAt((alphabet.indexOf(name.charAt(3)) + key) % 26);
        String k5 = ""+alphabet.charAt((alphabet.indexOf(name.charAt(4)) + key) % 26);


        //change the first character to upper case
        k1 = k1.toUpperCase();

        //generate the output
        String output = k1+k2+k3+k4+k5;

        //print out the output
        System.out.println(output);
        System.out.println(); //Menambahkan enter 

        //return the output
        return output;
    }


    public static void task3(){

        //declare and initialize the variables

        int priceOfCoffee = 15000;
        int priceOfTea = 10000;
        int priceOfPizza = 45000;
        String currency = "$";
        int numOfCoffe= 3;
        int numOfTea = 5;
        int numOfPizza = 1;
        String nameOfCustomer = "Albert";

        double discountOfCoffee = 0.1;
        double discountOfTea = 0.15;
        double discountOfPizza = 0.05;
        double takRate = 0.11;
        double cashInHand = 200000;

        // count number of items
        int numOfItems = numOfCoffe + numOfTea + numOfPizza;

        // count the total price
        double totalPrice = (((priceOfCoffee - (priceOfCoffee * discountOfCoffee)) * numOfCoffe)+ ((priceOfTea - (priceOfTea * discountOfTea)) * numOfTea) + ((priceOfPizza - (priceOfPizza * discountOfPizza)) * numOfPizza));
        // count the total price after tax
        double totalPriceAfterTax = totalPrice + (totalPrice*takRate);
        // print total price
        System.out.println("Total Price: "+ currency + totalPrice);

        // count the change 
        double change = cashInHand - totalPriceAfterTax;
        //printing the change
        System.out.println("Change: " +  currency + change);

        // count amount of donation
        double donation = change % 1000;
        System.out.println("Donation: "+ currency + donation);


        // print the receipt
        System.out.println("-----------------------------------\n");
        System.out.println("Name Of Customer: "+ nameOfCustomer);
        System.out.println("ORDERS");
        System.out.println("Number of items: " + numOfItems );
        System.out.println("Tea\t|\t" + numOfTea + "\t|\t"  + currency + ((priceOfTea - (priceOfTea * discountOfTea)) * numOfTea)  );
        System.out.println("Coffee\t|\t" + numOfCoffe + "\t|\t" + currency + ((priceOfCoffee - (priceOfCoffee * discountOfCoffee)) * numOfCoffe));
        System.out.println("Pizza\t|\t" + numOfPizza + "\t|\t"  +   currency + ((priceOfPizza - (priceOfPizza * discountOfPizza)) * numOfPizza));
        System.out.println("Total Before Tax: "+ currency + totalPrice);
        System.out.println("Tax: " + "11.0" + "%");
        System.out.println("Total After Tax:  "+ currency + totalPriceAfterTax);
        System.out.println("Amount Paid: "+ currency + cashInHand);
        System.out.println("Change: " + currency + change);
        System.out.println("Donation Amount: " + currency +  donation );
        System.out.println("-----------------------------------\n");
    }

    public static void task4(String numberOP) {
        int plusPosition = numberOP.indexOf("+");
        String partA = numberOP.substring(0,plusPosition);
        String partB = numberOP.substring(plusPosition+1);

        int numA = convertToInt(partA);
        int numB = convertToInt(partB);

        int result = numA + numB;
        System.out.println(result);

    }

    public static int convertToInt(String numString){

        numString = numString
                .replace("one","1")
                .replace("two","2")
                .replace("three","3")
                .replace("four","4")
                .replace("five","5")
                .replace("six","6")
                .replace("seven","7")
                .replace("eight","8")
                .replace("nine","9")
                .replace("ten","10");
        int number = Integer.parseInt(numString);
        return number;
    }
}
