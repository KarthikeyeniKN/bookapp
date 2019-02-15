package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDAO {
      /*
       * precondition
       * id,name,price must be valid
       */

	public void addBook(Book book) throws Exception{
		try {
			Connection connection = ConnectionUtil.getconnection();
			
			String sql = "insert into book (id,name,price,publishedDate) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,book.id);
			preparedStatement.setString(2,book.name);
			preparedStatement.setInt(3, book.price);
			preparedStatement.setDate(4, Date.valueOf(book.publishedDate));
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection,preparedStatement,null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("unable to insert");
		}
	}

	public void updateBook(Book book) throws Exception {
		try {
			Connection connection = ConnectionUtil.getconnection();
			String sql = "update book set name=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,book.name);
			preparedStatement.setInt(2,book.id);
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows updated: " + rows);
			ConnectionUtil.close(connection,preparedStatement,null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to update");
		}
	}

	public void deleteBook(Book book) throws Exception {
		try {
			Connection connection = ConnectionUtil.getconnection();
			String sql = "delete from book where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,book.id);
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows deleted: " + rows);
			ConnectionUtil.close(connection,preparedStatement,null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to delete");
		}
	}


	public ArrayList<Book> findAll() throws Exception {
		ArrayList<Book> bookList = new ArrayList<>();
		
		
		try {
			Connection connection = ConnectionUtil.getconnection();
			String sql = "select id,name,price,publishedDate from book";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			
			while (resultset.next()) {
				Book book2 = new Book();
				
				book2.id = resultset.getInt("id");
				book2.name = resultset.getString("name");
				book2.price = resultset.getInt("price");
				Date date = resultset.getDate("publishedDate");
				if (date == null) {
					book2.publishedDate = null;
					}
					else {
					book2.publishedDate = resultset.getDate("publishedDate").toLocalDate();
				}
				bookList.add(book2);
			}
			ConnectionUtil.close(connection,preparedStatement,resultset);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("unable to findAll");
		}
	
		
		return bookList;
	}

	public Book findById(Book book) throws Exception {
	//	Book book1 = new Book();
		 Book book1 = null;
		try {
			Connection connection = ConnectionUtil.getconnection();
			String sql = "select id,name,price,publishedDate from book where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, book.id);
			ResultSet resultset = preparedStatement.executeQuery();
		
			if (resultset.next()) {
				book1 = new Book();
				System.out.println();
				book1.id = resultset.getInt("id");
				book1.name = resultset.getString("name");
				book1.price = resultset.getInt("price");
			
				if (book1.publishedDate == null) {
				book1.publishedDate = null;
				}
				else {
				book1.publishedDate = resultset.getDate("publishedDate").toLocalDate();
			}
			}
			ConnectionUtil.close(connection,preparedStatement,resultset);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to selectById");
		}
		return book1;
	}
}
