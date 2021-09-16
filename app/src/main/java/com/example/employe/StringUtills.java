package com.example.employe;

public class StringUtills {
    public static String convertToCameCase(String input)
    {
        String arr[] = input.split(" ");
        if (arr.length <= 1) {
            return input;
        }
        StringBuilder cameCaseString = new StringBuilder(Character.toLowerCase(arr[0].charAt(0))+arr[0].substring(1));
        for (int i = 1; i < arr.length; i++) {
            cameCaseString.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1));
        }
        return cameCaseString.toString();
    }
    public static String convertToSmallcase(String input)
    {
        String arr[] = input.split(" ");
        if (arr.length <= 1) {
            return input;
        }
        StringBuilder lowerCaseString = new StringBuilder(Character.toLowerCase(arr[0].charAt(0))+arr[0].substring(1));
        for (int i = 0; i < arr.length; i++) {
            lowerCaseString.append(Character.toLowerCase(arr[i].charAt(0))).append(arr[i].substring(1));
        }
        return lowerCaseString.toString();
    }



}
