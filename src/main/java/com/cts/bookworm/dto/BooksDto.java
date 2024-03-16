package com.cts.bookworm.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BooksDto {
	private int bookId;

	@NotEmpty(message = "Can't be empty!")
	private String bookName;

	@NotEmpty(message = "Can't be empty!")
	private String authorName;

	@NotEmpty(message = "Can't be empty!")
	private String publisherName;

	@NotNull(message = "Can't be empty!")
	private Double price;

	@NotEmpty(message = "Can't be empty!")
	private String image;

	@NotEmpty(message = "Can't be empty!")
	private String bookDescription;

	@NotEmpty(message = "Can't be empty!")
	private String bookGenre;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
}
