package com.BasicRegexProblem;
public class UsernameValidator {
    public static void main(String[] args) {
        System.out.println(validateUsername("user_123"));
        System.out.println(validateUsername("123user"));
        System.out.println(validateUsername("us"));
    }

    public static String validateUsername(String username) {
        if (username.length() < 5 || username.length() > 15) {
            return "Invalid (length should be between 5 and 15 characters)";
        }
        String regex = "^[a-zA-Z][a-zA-Z0-9_]*$";

        if (username.matches(regex)) {
            return "Valid";
        } else {
            return "Invalid (should only contain letters, numbers, and underscores, and start with a letter)";
        }
    }
}






