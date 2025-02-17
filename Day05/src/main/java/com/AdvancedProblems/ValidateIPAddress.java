package com.AdvancedProblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {
    public static boolean checkVisaCard(String cardNumber){
        String regex = "4\\d{15}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }
    public static boolean checkMasterCard(String cardNumber){
        String regex = "5\\d{15}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }
    public static void main(String[] args) {
        // Created a scanner for inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the card number ");
        String cardNumber = sc.nextLine().trim();
        if(checkMasterCard(cardNumber)){
            System.out.println(cardNumber+" is a Master Credit Card");

        }
        else if(checkVisaCard(cardNumber))
            System.out.println(cardNumber+" is a Visa Credit Card");
        else System.out.println("Invalid Card Number");

    }
}
