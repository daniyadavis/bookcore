package com.litmus7.training.controller;

import java.util.List;

import com.litmus7.training.dto.BookDTO;
import com.litmus7.training.service.BookService;

public class BookController {
	BookService service = new BookService();

	public List<BookDTO> getAllBooks() {

		List<BookDTO> booklist = service.getAllBooks();

		return booklist;

	}

	public BookDTO getBookById(int id) {

		BookDTO book = service.getBookById(id);

		return book;

	}

	public BookDTO createBook(String name) {

		BookDTO book = service.createBook(name);
		return book;

	}

	public BookDTO getBookByAuthor(int id) {

		BookDTO book = service.getBookByAuthor(id);
		return book;
	}

	public void deleteBook(int id) {
		service.deleteBook(id);

	}

	public BookDTO updateBook(int newid, int id) {

		BookDTO book = service.updateBook(newid, id);
		return book;
	}

}
