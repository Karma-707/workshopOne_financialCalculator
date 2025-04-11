package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("WWelcome to Financial Calculator!\n" +
                "Which calculator would you like to use?\n" +
                "1) Mortgage calculator\n2) Future Value for CD\nSelect Calculator: ");

        int givenCommand = scanner.nextInt(); //get user input for which calculator

        switch (givenCommand){
            case 1: //Mortgage Calculator
                System.out.print("\nWelcome to Mortgage Calculator!" +
                        "\nWhat is your principal: ");
                double principal = scanner.nextDouble(); //user input principal val

                System.out.print("What is your interest rate (percentage without %): ");
                double interest = scanner.nextDouble(); //user input interest val
                interest = interest / 100; //convert interest from % to decimal

                System.out.print("What is your loan length: ");
                int loanYrs = scanner.nextInt(); //user input loan length (in yrs) val

                double monthlyInterest = interest / 12; //interest per month
                double monthlyPayment = principal*((monthlyInterest) * Math.pow((1+monthlyInterest),(loanYrs*12)) / (Math.pow((1+monthlyInterest),(loanYrs*12)) - 1));
                double totalInterest = (monthlyPayment * (loanYrs*12)) - principal;

                System.out.printf("Your expected monthly payment: $%.2f", monthlyPayment);
                System.out.printf("\nYour expected total interest paid: $%.2f", totalInterest);
                break;
            case 2: //Future Value for CD
                break;
            default:
                System.out.println("Invalid value, please try again");
        }



    }
}
