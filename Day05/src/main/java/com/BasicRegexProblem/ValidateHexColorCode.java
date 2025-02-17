package com.BasicRegexProblem;

public class ValidateHexColorCode {
    public static void main(String[] args) {
        System.out.println(validateHex("#12ffaa"));
        System.out.println(validateHex("12FFBB#"));
        System.out.println(validateHex("#11FFXX"));
    }

    public static String validateHex(String username) {
        String regex = "^#[0-9a-fA-F]{6}$";

        if (username.matches(regex)) {
            return "Valid";
        } else {
            return "Invalid (should only contain Hexadecimal value starting with '#')";
        }
    }
}
