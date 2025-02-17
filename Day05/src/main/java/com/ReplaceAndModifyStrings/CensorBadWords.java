package com.ReplaceAndModifyStrings;

import java.util.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");

        String output = replaceBadWords(input, badWords);
        System.out.println(output);
    }

    public static String replaceBadWords(String input, List<String> badWords) {
        for (String word : badWords) {
            input = input.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return input;
    }
}

