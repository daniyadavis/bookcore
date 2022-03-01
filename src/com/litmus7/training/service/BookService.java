package com.litmus7.training.service;

import java.util.List;
import java.util.Optional;

import com.litmus7.training.dao.BookDAO;
import com.litmus7.training.dto.BookDTO;

public class BookService {

	BookDAO dao = new BookDAO();

	public List<BookDTO> getAllBooks() {

		List<BookDTO> booklist = null;
		
			booklist = dao.getAllBooks();
		
		return booklist;

	}

	public BookDTO getBookById(int id) {

		BookDTO book = null;
		if (Optional.of(id).isPresent()) {
			book = dao.getBookById(id);
		}
		return book;

	}

	public BookDTO createBook(String name) {

		BookDTO book = null;
		if (Optional.of(name).isPresent()) {
			book = dao.createBook(name);
		}
		return book;
	}

	public BookDTO getBookByAuthor(int id) {
		BookDTO book = null;
		if (Optional.of(id).isPresent()) {
			book = dao.getBookByAuthor(id);
		}
		return book;
	}

	public void deleteBook(int id) {

		if (Optional.of(id).isPresent()) {
			dao.deleteBook(id);
		}
	}

	public BookDTO updateBook(int newid, int id) {
		BookDTO book = null;
		if (Optional.of(id).isPresent() && Optional.of(newid).isPresent()) {
			book = dao.updateBook(newid, id);
		}
		return book;

	}

}
