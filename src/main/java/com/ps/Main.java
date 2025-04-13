package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in); //scanner for all methods
    static int userInput = 0;

    public static void main(String[] args) {
        double interest; //declare interest

        //keep running the code till the users want to stop it
        while(userInput != 4) {
            menu(); //print menu options
            //userInput = checkIntInput(); //get user input for which calculator

            //switch statement depending on user choice
            switch (userInput) {
                case 1: //Mortgage Calculator
                    System.out.println("\n\n===============================");
                    System.out.println("Welcome to Mortgage Calculator!");
                    System.out.println("===============================");

                    System.out.print("What is your principal (without comma): $");
                    double principal = checkDoubleInput(); //user input principal val

                    System.out.print("What is your interest rate (percentage without %): ");
                    interest = checkDoubleInput(); //user input interest val
                    interest = interest / 100; //convert interest from % to decimal

                    System.out.print("What is your loan length in years: ");
                    int loanYrs = checkIntInput(); //user input loan length (in yrs) val

                    double monthlyInterest = interest / 12; //interest per month
                    double monthlyPayment = principal * ((monthlyInterest) * Math.pow((1 + monthlyInterest), (loanYrs * 12)) / (Math.pow((1 + monthlyInterest), (loanYrs * 12)) - 1));
                    double totalInterest = (monthlyPayment * (loanYrs * 12)) - principal;

                    System.out.println(
                            "\nSummary of Your Inputs:" +
                            "\nPrincipal: $" + principal +
                            "\nInterest Rate: " + (interest * 100) + "%" +
                            "\nLoan Length: " + loanYrs + " year(s)");

                    System.out.println("\nResults:");
                    System.out.printf("Your expected monthly payment: $%.2f", monthlyPayment);
                    System.out.printf("\nYour expected total interest paid: $%.2f", totalInterest);

                    //If user want to run the calculator again
                    tryAgain();
                    break;
                case 2: //Future Value for CD
                    System.out.println("\n\n========================================================");
                    System.out.println("Welcome to Future value for Certificate of Deposit (CD)!");
                    System.out.println("========================================================");

                    System.out.print("What is your deposit: $");
                    double deposit = checkDoubleInput(); //user input deposit val

                    System.out.print("What is your interest rate (percentage without %): ");
                    interest = checkDoubleInput();
                    interest = interest / 100; //convert interest from % to decimal

                    System.out.print("How many years: ");
                    int userYrs = checkIntInput(); //user input year val

                    double futureValue = deposit * Math.pow((1 + (interest / 365)), (365 * userYrs));
                    double totalInterestEarned = futureValue - deposit;

                    System.out.print(
                            "\nSummary of Your Inputs:" +
                            "\nDeposit: $" + deposit +
                            "\nInterest Rate: ");
                    System.out.printf("%.2f", (interest * 100));
                    System.out.println("%\nYear Length: " + userYrs + " year(s)");

                    System.out.println("\nResults:");
                    System.out.printf("Your Future Value: $%.2f", futureValue);
                    System.out.printf("\nTotal Interest Earned: $%.2f", totalInterestEarned);

                    tryAgain();
                    break;
                case 4: //quit user from program
                    goodByeMessage();
                    //System.out.println("Thanks for using Financial Calculators. Bye!");
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }

        }
    }

    //Method that display Menu control of users//
    public static void menu() {
        System.out.println("\n\n================================");
        System.out.println("Welcome to Financial Calculator!");
        System.out.println("================================");

        System.out.print(
                "Which calculator would you like to use?\n" +
                "Press 1: Mortgage calculator\n" +
                "Press 2: Future value for Certificate of Deposit (CD)\n" +
                "Press 4: Quit\n" +
                "Select Calculator: ");

        //while loop - when user choice not in menu, keep asking for correct input from menu
        userInput = checkIntInput();
        while (userInput != 1 && userInput != 2 && userInput != 4) {
            System.out.print("Invalid number choice, please try again: ");
            userInput = checkIntInput();
        }
    }

    public static void tryAgain() {
        System.out.print("\n\nDo you want to use the calculator again? (yes/no): ");

        //Eating the empty line
        String userChoice = scanner.nextLine();
        while (userChoice.equals("")) {
            userChoice = scanner.nextLine().trim();
        }

        while(true) {
            if (userChoice.equalsIgnoreCase("Yes") || userChoice.equalsIgnoreCase("Y")) {
                break; //break out of loop statement
            } else if (userChoice.equalsIgnoreCase("No") || userChoice.equalsIgnoreCase("N")) {
                goodByeMessage(); //send goodByeMessage to user outro!
                System.exit(0);
            }
            else { //all other outputs
                System.out.println("Invalid input, please try again");
                System.out.print("Do you want to use the calculator again? (yes/no): ");
                userChoice = scanner.nextLine();
            }
        }
    }

    //Check if user input is int then return int if true
    public static int checkIntInput() {
        String userInput = scanner.nextLine();

        //while user input isn't an int, keep letting them re-enter value
        while (!userInput.matches("\\d+")) {
            System.out.print("Sorry the value you entered isn't a valid number. Please try again: ");
            userInput = scanner.nextLine();
        }

        return Integer.parseInt(userInput); //return user value in int
    }

    //Check from checkIntInput method and pass to this method to convert to double
    public static double checkDoubleInput() {
//        int checkedNum = checkIntInput(userInput); //pass in checkIntInput method

        String userInput = scanner.nextLine();
        while (!userInput.matches("\\d+(\\.\\d+)?")) { //regex for int n decimal val
            System.out.print("Sorry the value you entered isn't a valid number. Please try again: ");
            userInput = scanner.nextLine();
        }
        return Double.parseDouble(String.valueOf(userInput)); //return double value
    }

    public static void goodByeMessage() {
        System.out.println("Thanks for using Financial Calculators. Bye!");
    }

}
