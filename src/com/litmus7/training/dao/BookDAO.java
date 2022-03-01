package com.litmus7.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.litmus7.training.dto.AuthorDTO;
import com.litmus7.training.dto.BookDTO;

import com.litmus7.training.utility.ConnectionUtility;
import com.litmus7.training.utility.SqlQuery;

public class BookDAO {
	static Logger log = Logger.getLogger(BookDAO.class.getName());
	static final Logger reporttLog = Logger.getLogger("reportsLogger");
	
	public List<BookDTO> getAllBooks() {

		List<BookDTO> booklist = new ArrayList<BookDTO>();

		ConnectionUtility cu = new ConnectionUtility();
		Connection con = cu.getConnection();
		try (Statement stmt = con.createStatement();) {

			reporttLog.info("\n\n<--------Get all Books---------->\n\n");

			ResultSet rs = stmt.executeQuery(SqlQuery.GET_BOOKS);

			while (rs.next()) {

				booklist.add(new BookDTO(rs.getInt(1), rs.getString(2)));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}

	public BookDTO getBookById(int id) {

		BookDTO book = null;

		reporttLog.info("\n\n<--------Get Book By Id---------->\n\n");
		ConnectionUtility cu = new ConnectionUtility();
		Connection con = cu.getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(SqlQuery.GET_BY_ID)) {

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				book = new BookDTO(rs.getInt(1), rs.getString(2));

			}
		} catch (SQLException e) {
			reporttLog.error(e);
		}

		return book;

	}

	public BookDTO createBook(String name) {

		BookDTO book = null;
		ConnectionUtility cu = new ConnectionUtility();
		Connection con = cu.getConnection();
		reporttLog.info("\n\n<--------create a Book Entry---------->\n\n");

		try (PreparedStatement pstmt = con.prepareStatement(SqlQuery.CREATE);
				PreparedStatement pstmt2 = con.prepareStatement(SqlQuery.GET_BY_NAME);) {
			pstmt.setString(1, name);
			pstmt2.setString(1, name);
			pstmt.executeUpdate();
			ResultSet rs = pstmt2.executeQuery();

			if (rs.next()) {

				book = new BookDTO(rs.getInt(1), rs.getString(2));

			}

		} catch (SQLException e) {
			reporttLog.error(e);
		}
		return book;
	}

	public BookDTO getBookByAuthor(int id) {
		BookDTO book = null;
		ConnectionUtility cu = new ConnectionUtility();
		try (Connection con = cu.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SqlQuery.GET_BY_AUTHOR);) {

			reporttLog.info("\n\n<--------Get book by Author---------->\n\n");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
			String bookname = "";
			if (rs.next()) {

				bookname = rs.getString(1);
				authors.add(new AuthorDTO(rs.getString(2), rs.getInt(3)));

			}
			while (rs.next()) {

				authors.add(new AuthorDTO(rs.getString(2), rs.getInt(3)));
			}

			book = new BookDTO(id, bookname, authors);

		} catch (SQLException e) {

			reporttLog.error(e);
		}
		return book;
	}

	public void deleteBook(int id) {

		ConnectionUtility cu = new ConnectionUtility();
		Connection con = cu.getConnection();
		reporttLog.info("\n\n<--------Delete a Book Entry---------->\n\n");

		try (PreparedStatement pstmt = con.prepareStatement(SqlQuery.DELETE_BOOK)) {
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			reporttLog.error(e);
		}

	}

	public BookDTO updateBook(int newid, int id) {

		BookDTO book = null;
		ConnectionUtility cu = new ConnectionUtility();
		Connection con = cu.getConnection();
		reporttLog.info("\n\n<--------Update a Book Entry---------->\n\n");

		try (PreparedStatement pstmt = con.prepareStatement(SqlQuery.UPDATE);
				PreparedStatement pstmt2 = con.prepareStatement(SqlQuery.GET_BY_ID);) {
			pstmt.setInt(1, newid);
			pstmt.setInt(2, id);
			pstmt2.setInt(1, newid);
			pstmt.executeUpdate();
			ResultSet rs = pstmt2.executeQuery();

			if (rs.next()) {

				book = new BookDTO(rs.getInt(1), rs.getString(2));

			}

		} catch (SQLException e) {
			reporttLog.error(e);
		}
		return book;

	}

}
