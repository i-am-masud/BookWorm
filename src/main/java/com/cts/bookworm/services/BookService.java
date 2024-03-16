package com.cts.bookworm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bookworm.entities.Books;
import com.cts.bookworm.entities.User;
import com.cts.bookworm.repos.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public void addBooks(Books books) {
		if (books != null) {
			bookRepository.save(books);
		}
	}

	public List<Books> getGenreBooks(String genreName) {
		List<Books> booksList = bookRepository.findByBookGenre(genreName);
		return booksList;
	}

	public Books getBook(int bookId) {
		Books book = bookRepository.findById(bookId).get();
		if (book != null) {
			return book;
		}
		return null;
	}

	public List<Books> findBookByBookName(String bookName) {
		List<Books> books = bookRepository.findByBookNameContainsIgnoreCase(bookName);
		if (books.size() > 0) {
			return books;
		}
		return null;
	}

	public List<Books> findAllBooks() {
		List<Books> bookList = bookRepository.findAll();
		return bookList;

	}
	
	public void UpdateBooks(Books books) {
		if (books != null) {
			bookRepository.save(books);
		}
	}
	
	public void deleteBook(int bookId) {
		if (bookRepository.existsById(bookId)) {
			bookRepository.deleteById(bookId);
		}
	}

}
