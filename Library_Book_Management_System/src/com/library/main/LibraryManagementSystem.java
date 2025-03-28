package com.library.main;

import java.util.Scanner;

import com.library.Service.Library;

public class LibraryManagementSystem {
	
	public static void main(String[] args) {
		
		Library library = new Library();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n📚 Digital Library Book Management System 📚");
			System.out.println("1️⃣ Add Book");
			System.out.println("2️⃣ View All Books");
			System.out.println("3️⃣ Search Book");
			System.out.println("4️⃣ Update Book Details");
			System.out.println("5️⃣ Delete Book");
			System.out.println("6️⃣ Exit");
			System.out.print("➡ Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); 
			
			switch (choice) {
			case 1:
				library.addBook();
				break;
			case 2:
				library.viewBooks();
				break;
			case 3:
				library.searchBook();
				break;
			case 4:
				library.updateBook();
				break;
			case 5:
				library.deleteBook();
				break;
			case 6:
				System.out.println("👋 Exiting System. Thank you!");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("❌ Invalid choice. Please try again.");
			}
		}
	}
}
