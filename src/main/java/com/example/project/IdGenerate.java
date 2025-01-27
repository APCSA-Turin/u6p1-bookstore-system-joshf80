package com.example.project;

public class IdGenerate{
    
    private static String currentId = "99";

    public IdGenerate() {}

    // Static method to retrieve the current ID.
    public static String getCurrentId()  {
        return currentId;
    }

    // Static method to reset the current ID back to 99
    public static void reset() {
        currentId = "99";
    }

    // Static method to generate the next ID.
    public static void generateID()  {
        // Parse the current ID to an integer, increment it by 1, then convert it back to a string
        int temp = Integer.parseInt(currentId) + 1;
        currentId = Integer.toString(temp);
    }
}