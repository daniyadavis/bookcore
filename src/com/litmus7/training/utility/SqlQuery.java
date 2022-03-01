package com.litmus7.training.utility;

public class SqlQuery {

	public final static String GET_BOOKS = "select * from book";
	public final static String DELETE_BOOK = "DELETE FROM book WHERE book_id=?";
	public final static String GET_BY_ID = "SELECT * FROM book WHERE book_id=?";
	public final static String GET_BY_NAME = "SELECT * FROM book WHERE book_name=?";
	public final static String CREATE = "INSERT INTO book (book_name) values(?)";
	public final static String GET_BY_AUTHOR = "SELECT book.book_name,author.author_name,author.author_id "
			+ "FROM book,author,book_author_rel WHERE book.book_id=book_author_rel.book_id "
			+ "AND book_author_rel"
			+ ".author_id=author.author_id AND book.book_id=?";
	public final static String UPDATE = "UPDATE book SET book_id =?, book_name = 'hearts' WHERE book_id = ?";

}
