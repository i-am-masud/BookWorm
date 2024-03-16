package com.cts.bookworm.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bookworm.entities.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {
	
	List<Books> findByBookGenre(String genreName);
	
	List<Books> findByBookNameContainsIgnoreCase(String bookName);
	
//	Books deleteByBookId(int bookId);
}
