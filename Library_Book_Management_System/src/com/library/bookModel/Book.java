package com.library.bookModel;

public class Book {

	private int id;
	private String title;
	private String author;
	private String genre;
	private String availabilityStatus;

	public Book(int id, String title, String author, String genre, String availabilityStatus) {
		
		  if (title == null || title.trim().isEmpty()) {
		        throw new IllegalArgumentException("Title cannot be empty.");
		    }
		    if (author == null || author.trim().isEmpty()) {
		        throw new IllegalArgumentException("Author cannot be empty.");
		    }
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availabilityStatus = availabilityStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		 if (title == null || title.trim().isEmpty()) {
		        throw new IllegalArgumentException("Title cannot be empty.");
		    }
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		 if (author == null || author.trim().isEmpty()) {
		        throw new IllegalArgumentException("Author cannot be empty.");
		    }
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	@Override
	public String toString() {
		return "Book ID: " + id + " | Title: " + title + " | Author: " + author + " | Genre: " + genre + " | Status: "
				+ availabilityStatus;
	}
}
