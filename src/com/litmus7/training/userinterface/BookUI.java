package com.litmus7.training.userinterface;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.litmus7.training.controller.BookController;
import com.litmus7.training.dao.BookDAO;
import com.litmus7.training.dto.BookDTO;
import com.litmus7.training.utility.ConnectionUtility;
import com.litmus7.training.utility.SqlQuery;

public class BookUI {

	static Logger log = Logger.getLogger(BookUI.class.getName());
	static final Logger reporttLog = Logger.getLogger("reportsLogger");
	static final Logger Log = Logger.getLogger("FILE");

	public static void main(String[] args) {
		BookController controller = new BookController();
       
		reporttLog.info("lets go through Book Details\n");
		reporttLog.info("we can do CRUD operations on Book Table");

		try (FileReader reader = new FileReader(".//config//l7database.properties");) {

			Properties p = new Properties();

			p.load(reader);
			//new ConnectionUtility(p.getProperty("DB_URL"), p.getProperty("User"), p.getProperty("Password"));

			List<BookDTO> booklist = controller.getAllBooks();

			booklist.stream().forEach(
					book -> Log.info("                         " + book.getId() + "          " + book.getName()));

			log.info("\n\n");
			BookDTO bookById = controller.getBookById(2);
			Log.info("                         " + bookById.getId() + "          " + bookById.getName());

			BookDTO bookByName = controller.createBook("Book2");
			Log.info("                         " + bookByName.getId() + "          " + bookByName.getName());

			log.info("\n\n");
			controller.deleteBook(3);

			log.info("\n\n");
			BookDTO updateBook = controller.updateBook(1, 4);
			Log.info("                         " + updateBook.getId() + "          " + updateBook.getName());

			BookDTO bookByauthor = controller.getBookByAuthor(2);

			Log.info("                         " + bookByauthor.getId() + "          " + bookByauthor.getName()
					+ "          " + bookByauthor.getAuthors());

		} catch (Exception e) {
			reporttLog.error(e);
		}
	}
}
