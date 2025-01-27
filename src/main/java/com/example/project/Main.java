package com.example.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************************************");
        System.out.println("*                                                *");
        System.out.println("*          📚 Welcome to Book Haven 📚           *");
        System.out.println("*                                                *");
        System.out.println("**************************************************");
        System.out.println("    A world of books and readers awaits you!");

        while (true) {
            // print all options
            System.out.println("\nMain Menu:");
            System.out.println("[1] Add a New Book");
            System.out.println("[2] Remove a Book");
            System.out.println("[3] Show All Books");
            System.out.println("[4] Register a User");
            System.out.println("[5] Remove a User");
            System.out.println("[6] Show All Users");
            System.out.println("[7] Check Out a Book");
            System.out.println("[8] Check In a Book");
            System.out.println("[9] Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // get user input

            // Adding new book option
            if (choice == 1) {
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();

                System.out.print("Enter Author: ");

                String author = scanner.nextLine();

                System.out.print("Enter Year Published: ");
                int year = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();

                System.out.print("Enter Quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                bookStore.addBook(new Book(title, author, year, isbn, quantity));
                System.out.println("✅ Book added successfully!");
            } else if (choice == 2) { // Removing Book option
                System.out.print("Enter the Title of the Book to Remove: ");
                String title = scanner.nextLine();
                Book[] books = bookStore.getBooks();

                boolean found = false;
                // Loop through books to find entered title
                for (Book book : books) {
                    // If book exists in user inventory and is book that is being removed
                    if (book != null && book.getTitle().equals(title)) {
                        bookStore.removeBook(book);
                        System.out.println("✅ Book removed successfully!");
                        found = true;
                        break; // end loop if book removed early.
                    }
                }
                if (!found) {
                    System.out.println("❌ Book not found!");
                }
            } else if (choice == 3) { // Print all books
                Book[] books = bookStore.getBooks();
                // If array empty print special text
                if (books.length == 0) {
                    System.out.println("📚 No books available in the store.");
                } else { //  otherwise loop through Books and print each books information
                    System.out.println("📚 Available Books:");
                    for (Book book : books) {
                        System.out.println(book.bookInfo());
                    }
                }
            } else if (choice == 4) { // Registering a user
                System.out.print("Enter User Name: "); 
                String userName = scanner.nextLine(); // get input

                // id handling
                IdGenerate.generateID();
                String userId = IdGenerate.getCurrentId();

                bookStore.addUser(new User(userName, userId)); // add user to bookstore
                System.out.println("✅ User registered successfully with ID: " + userId);
            } else if (choice == 5) { // removing a user
                System.out.print("Enter the Name of the User to Remove: ");
                String userName = scanner.nextLine();
                User[] users = bookStore.getUsers(); // retrieve bookstore users
                boolean found = false;
                // loop through users and remove user if found
                for (User user : users) {
                    if (user != null && user.getName().equals(userName)) {
                        bookStore.removeUser(user);
                        System.out.println("✅ User removed successfully!");
                        found = true;
                        break; // end loop if user removed early
                    }
                }
                if (!found) {
                    System.out.println("❌ User not found!");
                }
            } else if (choice == 6) { // printing all users and their info
                User[] users = bookStore.getUsers();
                System.out.println("👥 Registered Users:");
                // loop through registered users and print their info
                for (User user : users) { 
                    if (user != null) {
                        System.out.println(user.userInfo());
                    }
                }
            } else if (choice == 7) { // Check out a book
                System.out.print("Enter User Name: ");
                String userName = scanner.nextLine();

                System.out.print("Enter Book Title: ");
                String bookTitle = scanner.nextLine();

                User[] users = bookStore.getUsers();
                Book[] books = bookStore.getBooks();
                User foundUser = null;
                Book foundBook = null;

                // Find user and book
                for (User user : users) {
                    if (user != null && user.getName().equals(userName)) {
                        foundUser = user;
                        break;
                    }
                }

                for (Book book : books) {
                    if (book != null && book.getTitle().equals(bookTitle)) {
                        foundBook = book;
                        break;
                    }
                }

                if (foundUser != null && foundBook != null) {
                    Book[] userBooks = foundUser.getBooks();
                    boolean added = false;
                    for (int i = 0; i < userBooks.length; i++) {
                        if (userBooks[i] == null) {
                            userBooks[i] = foundBook;
                            foundUser.setBooks(userBooks);
                            foundBook.setQuantity(foundBook.getQuantity() - 1);
                            System.out.println("✅ Book checked out successfully");
                            added = true;
                            break;
                        }
                    }
                    if (!added) {
                        System.out.println("❌ User has already borrowed maximum books");
                    }
                } else {
                    if (foundUser == null) {
                        System.out.println("❌ User not found");
                    }
                    if (foundBook == null) {
                        System.out.println("❌ Book not found or unavailable");
                    }
                }
            } else if (choice == 8) { // Check in a book
                System.out.print("Enter User Name: ");
                String userName = scanner.nextLine();

                System.out.print("Enter Book Title: ");
                String bookTitle = scanner.nextLine();

                User[] users = bookStore.getUsers();
                User foundUser = null;

                // Find user
                for (User user : users) {
                    if (user != null && user.getName().equals(userName)) {
                        foundUser = user;
                        break;
                    }
                }

                if (foundUser != null) {
                    Book[] userBooks = foundUser.getBooks();
                    boolean removed = false;

                    for (int i = 0; i < userBooks.length; i++) {
                        if (userBooks[i] != null && userBooks[i].getTitle().equals(bookTitle)) {
                            Book bookToReturn = userBooks[i];
                            userBooks[i] = null;
                            foundUser.setBooks(userBooks);

                            // Increment book quantity in the store
                            Book[] books = bookStore.getBooks();
                            for (Book book : books) {
                                if (book.getTitle().equals(bookTitle)) {
                                    book.setQuantity(book.getQuantity() + 1);
                                    break;
                                }
                            }

                            System.out.println("✅ Book checked in successfully!");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("❌ User does not have this book");
                    }
                } else {
                    System.out.println("❌ User not found");
                }
            } else if (choice == 9) { // quit
                System.out.println("👋 Thank you for using Book Haven!");
                break;
            } else { // invalid input
                System.out.println("❌ Invalid choice");
            }
        }

        scanner.close();
    }
}
