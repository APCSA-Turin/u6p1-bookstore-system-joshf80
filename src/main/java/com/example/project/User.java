package com.example.project;

public class User{
    private String name;
    private String Id;
    private Book[] books = new Book[5];

    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public String bookListInfo() { 
        String s = "";
        for (Book book : books) {
           s += book.bookInfo() + "\n";
        }
        return s;
    }

    public String userInfo() {
        String s = "Name: " + name + "\n" + "ID: " + Id + "\n" + "Books:" + "\n" + bookListInfo();
        return s;
    } //returns  "Name: []\nID: []\nBooks:\n[]"
       
}