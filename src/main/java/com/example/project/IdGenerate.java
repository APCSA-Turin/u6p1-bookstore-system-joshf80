package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentId = "99";

    // //requires one empty constructor

    public static String getCurrentId()  {
        return currentId;
    }

    public static void reset() {
        currentId = "99";
    }


    public static void generateID()  {
        int temp = Integer.parseInt(currentId) + 1;
        currentId = Integer.toString(temp);
    }
}