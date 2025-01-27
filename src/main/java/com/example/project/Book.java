package com.example.project;

public class Book{
    // book attributes
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    // book constructor
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        this.title = title;;
        this.author = author;;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // methods to return attributes of book

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getQuantity() {
        return quantity;
    }

    // methods to change attributes of book

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"

    public String bookInfo() {
        String s = "Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYearPublished() + ", ISBN: " + getIsbn() + ", Quantity: " + getQuantity();
        return s;
    } 
       
}