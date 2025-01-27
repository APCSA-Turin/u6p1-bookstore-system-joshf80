package com.example.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************************************");
        System.out.println("*                                                *");
        System.out.println("*          📚 Welcome to Book Store 📚           *");
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
            System.out.println("[7] Exit");
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
            } else if (choice == 7) { // quit
                System.out.println("👋 Thank you for using Book Haven! Goodbye!");
                break;
            } else { // invalid input
                System.out.println("❌ Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
