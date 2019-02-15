package com.chainsys.jdbc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.Test;

public class BookDAOTest {

	@Test
	public void testAddBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id = 1;
		book.name = "arvi";
		book.price = 401;
		book.publishedDate = LocalDate.parse("2019-09-15");
		bookDAO.addBook(book);
		
		Book book1 = new Book();
		book1.id= 1;
		Book b = bookDAO.findById(book1);
		
		assertEquals(book.id,b.id);
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id=84;
		book.name="c++";
		bookDAO.updateBook(book);
		
		Book book1 = new Book();
		book1.id = 84;
		Book b = bookDAO.findById(book1);
		
		assertEquals(book.name,b.name);
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id=85;
		bookDAO.deleteBook(book);
		
		Book book1 = new Book();
		book1.id = 85;
		Book b = bookDAO.findById(book1);
		assertEquals(null,b);
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testFindAll() throws Exception {
		BookDAO bookDAO = new BookDAO();
		bookDAO.findAll();
		//fail("Not yet implemented");
	}

	@Test
	public void testFindById() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id= 1;
		bookDAO.findById(book);
		
		Book book1 = new Book();
		book1.id = 1;
		Book b = bookDAO.findById(book1);
		assertEquals(book.id,b.id);
		
		
		//fail("Not yet implemented");
	}

}
