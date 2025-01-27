package com.example.project;

public class BookStore {

    private Book[] books = new Book[0];
    private User[] users = new User[10];

    public BookStore() {}

    // get and setter methods

    public User[] getUsers() {
        return users;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    
    // Adds a new user to the bookstore if there is space available (i.e., if the position is null)
    public void addUser(User user) {
        // Loop through the users array to find an empty spot
        for (int i = 0; i < users.length; i++) {
            // If a null position is found, add the user and exit the loop
            if (users[i] == null) {
                users[i] = user;
                break;
            }
        }
    }

    // Removes a user from the bookstore. Sets the user position to null and consolidates the users array.
    public void removeUser(User user) {
        // Loop through the users array to find the user to remove
        for (int i = 0; i < users.length; i++) {
            // If the user is found, set the position to null (removes the user)
            if (users[i] == user) {
                users[i] = null;
                break;
            }
        }
        // Consolidate the users array after removal to avoid having null gaps
        consolidateUsers();
    }

    // Consolidates the users array by removing any null values, shifting non-null users into a new array
    public void consolidateUsers() {
        // Create a temporary array with the same size as the current users array
        User[] temp = new User[users.length];
        int index = 0;

        // Loop through the users and copy non-null elements into new array
        for (User user : users) {
            if (user != null) {
                temp[index++] = user;
            }
        }
        // Replace original users array
        users = temp;
    }

    // Adds a new book to the bookstore
    public void addBook(Book book) {
        // Get the current length of the books array
        int length = books.length;
    
        // Create a new array that is one element longer
        Book[] newBooks = new Book[length + 1];
    
        // Copy all existing books
        for (int i = 0; i < length; i++) {
            newBooks[i] = books[i];
        }
    
        // Add the new book
        newBooks[length] = book;
        
        // Replace the old books array
        books = newBooks;
    }
    

    // Removes a book from the bookstore by either reducing its quantity or setting it to null
    public void removeBook(Book book) {
        // Loop through the books array to find the book to remove
        for (int i = 0; i < books.length; i++) {
            // If the book is found
            if (books[i] == book) {
                // If the books quantity is 1, remove it from the array (set to null)
                if (books[i].getQuantity() == 1) {
                    books[i] = null;
                } else {
                    // Otherwise reduce the books quantity by 1
                    books[i].setQuantity(books[i].getQuantity() - 1);
                }
            }
        }
        // Consolidate the books array
        consolidateBooks();
    }

    // Consolidates the books array by removing any null values and creating a new array with only non-null books
    public void consolidateBooks() {
        // Count the number of non-null books in the current array
        int nonNullCount = 0;
        for (Book book : books) {
            if (book != null) {
                nonNullCount++;
            }
        }

        // Create a new array with the size needed for the non-null books
        Book[] temp = new Book[nonNullCount];
        int index = 0;

        // Copy non-null books into the new array
        for (Book book : books) {
            if (book != null) {
                temp[index++] = book;
            }
        }

        // Replace array
        books = temp;
    }

    // Inserts a new book at a specific index in the books array, shifting the other books to accommodate the new one
    public void insertBook(Book book, int index) {
        // Create a new array that is one element longer than the current books array to make space
        Book[] newBooks = new Book[books.length + 1];
    
        // Copy all books up to the insertion index
        for (int i = 0; i < index; i++) {
            newBooks[i] = books[i];
        }
    
        // Insert the new book
        newBooks[index] = book;
    
        // Copy the remaining books after the insertion
        for (int i = index; i < books.length; i++) {
            newBooks[i + 1] = books[i];
        }
    
        // Replace array
        books = newBooks;
    }
    
    

}
