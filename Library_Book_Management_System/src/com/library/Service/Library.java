package com.library.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library.bookModel.Book;

public class Library {

	private List<Book> books = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	// Add Book
	public void addBook() {
		System.out.print("Enter Book ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		// Check if book ID already exists
		if (getBookById(id) != null) {
			System.out.println("❌ Book ID already exists. Please use a unique ID.");
			return;
		}

		System.out.print("Enter Title: ");
		String title;
		while (true) {
			title = scanner.nextLine().trim();
			if (!title.isEmpty())
				break;
			System.out.print("Error: Title cannot be empty. Please enter again: ");
		}

		System.out.print("Enter Author: ");
		String author;
		while (true) {
			author = scanner.nextLine().trim();
			if (!author.isEmpty())
				break;
			System.out.print("Error: Author cannot be empty. Please enter again: ");
		}

		System.out.print("Enter Genre: ");
		String genre = scanner.nextLine();

		System.out.print("Enter Availability (Available/Checked Out): ");
		String status = scanner.nextLine();

		books.add(new Book(id, title, author, genre, status));
		System.out.println("✅ Book added successfully!");
	}

	// View All Books
	public void viewBooks() {
		if (books.isEmpty()) {
			System.out.println("📚 No books found in the library.");
			return;
		}
		System.out.println("\n📚 Book List:");
		for (Book book : books) {
			System.out.println(book);
		}
	}

	// Search Book by ID or Title
	public void searchBook() {
		System.out.print("Enter Book ID or Title to search: ");
		String searchQuery = scanner.nextLine();

		for (Book book : books) {
			if (String.valueOf(book.getId()).equals(searchQuery) || book.getTitle().equalsIgnoreCase(searchQuery)) {
				System.out.println("🔍 Found Book: " + book);
				return;
			}
		}
		System.out.println("❌ Book not found.");
	}

	// Update Book Details
	public void updateBook() {
		System.out.print("Enter Book ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Book book = getBookById(id);
		if (book == null) {
			System.out.println("❌ Book not found.");
			return;
		}

		System.out.print("Enter new Title (Leave blank to keep existing): ");
		String newTitle = scanner.nextLine();
		if (!newTitle.trim().isEmpty()) {
			book.setTitle(newTitle);
		}

		System.out.print("Enter new Author (Leave blank to keep existing): ");
		String newAuthor = scanner.nextLine();
		if (!newAuthor.trim().isEmpty()) {
			book.setAuthor(newAuthor);
		}

		System.out.print("Enter new Genre (Leave blank to keep existing): ");
		String newGenre = scanner.nextLine();
		if (!newGenre.isEmpty())
			book.setGenre(newGenre);

		System.out.print("Enter new Availability Status (Available/Checked Out): ");
		String newStatus = scanner.nextLine();
		book.setAvailabilityStatus(newStatus);

		System.out.println("✅ Book details updated successfully!");
	}

	// Delete Book
	public void deleteBook() {
		System.out.print("Enter Book ID to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Book book = getBookById(id);
		if (book == null) {
			System.out.println("❌ Book not found.");
			return;
		}

		books.remove(book);
		System.out.println("🗑 Book deleted successfully!");
	}

	// Get Book by ID
	private Book getBookById(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}
}
