package com.ps;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in); //scanner for all methods
    static int givenCommand = 0;

    public static void main(String[] args) {
        double interest; //declare interest

        //keep running the code till the users want to stop it
        while(givenCommand != 4) {
            menu(); //print menu options
            givenCommand = scanner.nextInt(); //get user input for which calculator

            switch (givenCommand) {
                case 1: //Mortgage Calculator
                    System.out.print("\nWelcome to Mortgage Calculator!" +
                            "\nWhat is your principal: $");
                    double principal = scanner.nextDouble(); //user input principal val

                    System.out.print("What is your interest rate (percentage without %): ");
                    interest = scanner.nextDouble(); //user input interest val
                    interest = interest / 100; //convert interest from % to decimal

                    System.out.print("What is your loan length: ");
                    int loanYrs = scanner.nextInt(); //user input loan length (in yrs) val

                    double monthlyInterest = interest / 12; //interest per month
                    double monthlyPayment = principal * ((monthlyInterest) * Math.pow((1 + monthlyInterest), (loanYrs * 12)) / (Math.pow((1 + monthlyInterest), (loanYrs * 12)) - 1));
                    double totalInterest = (monthlyPayment * (loanYrs * 12)) - principal;

                    System.out.printf("Your expected monthly payment: $%.2f", monthlyPayment);
                    System.out.printf("\nYour expected total interest paid: $%.2f", totalInterest);

                    //If user want to run the calculator again
                    System.out.print("\nDo you want to use the calculator again? (yes/no)");

                    tryAgain();
                    break;
                case 2: //Future Value for CD
                    System.out.print("\nWelcome to Future Value for CD!" +
                            "\nWhat is your deposit: $");
                    double deposit = scanner.nextDouble(); //user input deposit val

                    System.out.print("What is your interest rate (percentage without %): ");
                    interest = scanner.nextDouble();
                    interest = interest / 100; //convert interest from % to decimal

                    System.out.print("How many years: ");
                    int userYrs = scanner.nextInt(); //user input year val

                    double futureValue = deposit * Math.pow((1 + (interest / 365)), (365 * userYrs));
                    double totalInterestEarned = futureValue - deposit;

                    System.out.printf("Your Future Value: $%.2f", futureValue);
                    System.out.printf("\nTotal Interest Earned: $%.2f", totalInterestEarned);

                    tryAgain();
                    break;
                case 4: //quit user from program
                    System.out.println("Thanks for using Financial Calculators. Bye!");
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }

        }
    }

    //Method that display strings//
    public static void menu() {
        System.out.print("Welcome to Financial Calculator!\n" +
                "Which calculator would you like to use?\n" +
                "Press 1: Mortgage calculator\n" +
                "Press 2: Future Value for CD\n" +
                "Press 4: Quit\n" +
                "Select Calculator: ");
    }

    public static void tryAgain() {
        String userInput = scanner.nextLine();

        while(true) {
            if (userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("Y")) {
                break; //break out of loop statement
            } else if (userInput.equalsIgnoreCase("No") || userInput.equalsIgnoreCase("N")) {
                givenCommand = 4; //Jump to case 4 for the outro
                break;
            }
            else { //all other outputs
                System.out.println("Invalid input, please try again");
                System.out.print("Do you want to use the calculator again? (yes/no)");
                userInput = scanner.nextLine();
            }
        }
    }

}
