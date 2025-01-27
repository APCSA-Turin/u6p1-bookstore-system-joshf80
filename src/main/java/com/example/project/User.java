package com.example.project;

public class User {
    private String name;  // User's name
    private String Id;  // User's unique ID
    private Book[] books = new Book[5];  // Array to store up to 5 books

    // Constructor to initialize the name and ID of the user
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }

    // Getter method for the user's name
    public String getName() {
        return name;
    }

    // Setter method for the user's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for the user's ID
    public String getId() {
        return Id;
    }

    // Setter method for the user's ID
    public void setId(String Id) {
        this.Id = Id;
    }

    // Getter method for the user's books array
    public Book[] getBooks() {
        return books;
    }

    // Setter method for the user's books array
    public void setBooks(Book[] books) {
        this.books = books;
    }

    // Returns a string with information about the user's books
    public String bookListInfo() { 
        String s = "";  // Initialize an empty string for the book list
        for (Book book : books) {  // Iterate through each book in the array
            if (book == null) { 
                s += "empty\n";  // Add "empty" to the string if the book is null
            } else {
                s += book.bookInfo() + "\n";  // Add the book's info to the string
            }
        }
        return s;  // Return the book list information
    }

    // Returns a string with the user's full information including books
    public String userInfo() {
        String s = "Name: " + name + "\n" + "Id: " + Id + "\n" + "Books:" + " \n" + bookListInfo();
        return s;  // Return the user's full information
    }
}
