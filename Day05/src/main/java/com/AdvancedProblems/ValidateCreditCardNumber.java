package com.AdvancedProblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCardNumber {
    public static boolean isValidIP(String address){
        String regex = "\\d{1,4}.\\d{1,4}.\\d{1,4}.\\d{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return  matcher.matches();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP address : ");
        String address = sc.nextLine().trim();

        if(isValidIP(address))
            System.out.println(" Valid IP address");
        else System.out.println(" Invalid IP addreses");
    }
}
