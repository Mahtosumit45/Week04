package com.BasicRegexProblem;

public class LicensePlateValidator {
    public static void main(String[] args) {
        System.out.println(validateLicensePlate("AB1234"));
        System.out.println(validateLicensePlate("A12345"));
        System.out.println(validateLicensePlate("abc1234"));
        System.out.println(validateLicensePlate("AB12"));
    }

    public static String validateLicensePlate(String licensePlate) {
        String regex = "^[A-Z]{2}[0-9]{4}";
        if (licensePlate.matches(regex)) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }
}

