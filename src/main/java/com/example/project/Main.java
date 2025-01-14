package com.example.project;

public class Main {
    public static void main(String[] args) {
        IdGenerate.reset();
       
        IdGenerate.generateID(); //100
        IdGenerate.generateID(); //101
        IdGenerate.generateID(); //102
        IdGenerate.generateID(); //103
        System.out.println(IdGenerate.getCurrentId());
    }
}
