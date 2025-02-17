package com.ReplaceAndModifyStrings;

public class ReplaceMultipleSpacesWithSingleSpace {
    public static String removeExtraSpace(String text){
        String updatedString = text.replaceAll("\\s+"," ");
        return updatedString;
    }
    public static void main(String[] args) {
        String text = "This is an          example  with  multiple  spaces.";
        String updatedText = removeExtraSpace(text);
        System.out.println(updatedText);

    }
}
