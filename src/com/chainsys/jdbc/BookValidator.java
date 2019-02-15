package com.chainsys.jdbc;

public class BookValidator {
	 public void validateAdd(Book book) throws Exception {
			if(book.name.equals("kar")) {
	            throw new Exception("Invalid name");
	        }
	        if(book.price<=0)
	        {
	            throw new Exception("Invalid price");
	        }
	    }
	 public void validateUpdate(Book book) throws Exception {
		 if(book.id<=0) {
			 throw new Exception("Invalid Id");
		 }
		 if(book.name==null) {
	            throw new Exception("Invalid name");
	        }
	 }
	 public Book validateDelete(Book book) throws Exception {
		 if(book.id<=0) {
			 throw new Exception("Invalid Id");
		 }
		return book;
	 }
	 public Book validatefindById(Book book) throws Exception {
		 if(book.id<=0) {
			 throw new Exception("Invalid Id");
		 }
		return book;
	 }
}
