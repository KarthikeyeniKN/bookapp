package com.chainsys.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TestBookDAO {

	public static void main(String[] args) throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		int choice=0;
		Scanner scanner = new Scanner(System.in);
		do{
			    
				System.out.println("Enter 1 insert, 2 update , 3 delete,4 findById,5 find all");
				int a = scanner.nextInt();
				BookValidator validateBook = new BookValidator();
				switch (a) {
				case 1:
				System.out.println("Enter name,price,publishedDate in  to add");
				String name = scanner.next();
				int price = scanner.nextInt();
				String inputDate = scanner.next();
				LocalDate Date = LocalDate.parse(inputDate);
				
				book.name = name;
				book.price = price;
				book.publishedDate = Date;
				
					try {
						validateBook.validateAdd(book);
						bookDAO.addBook(book);
						bookDAO.findAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
				break;
				
				case 2:
					System.out.println("Enter the name to be changed");
					String name1 = scanner.next();
					System.out.println("enter the id");
					int id1 = scanner.nextInt();
					book.id=id1;
					book.name=name1;
					try {
						validateBook.validateUpdate(book);
						bookDAO.updateBook(book);
						bookDAO.findAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
				case 3:
					System.out.println("enter the id");
					int id2 = scanner.nextInt();
					book.id = id2;
					try {
						validateBook.validateDelete(book);
						bookDAO.deleteBook(book);
						bookDAO.findAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("enter the id");
					int id4 = scanner.nextInt();
					book.id=id4;
					try {
						validateBook.validatefindById(book);
						Book b = bookDAO.findById(book);
						if(b!=null) {
							System.out.println(b.id);
							System.out.println(b.name);
							System.out.println(b.price);
							System.out.println(b.publishedDate);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				break;	
				case 5:
					try {
					 bookDAO.findAll();
					 ArrayList<Book>b1 = bookDAO.findAll();
					if (b1.isEmpty()) {
						System.out.println("No records");
					} else {
					 for (Book b2:b1) {
							System.out.println(b2.id);
							System.out.println(b2.name);
							System.out.println(b2.price);
							System.out.println(b2.publishedDate);
						}
					}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				default :
					break;
					
				}
		
				System.out.println("Enter 1 to continue");
				choice = scanner.nextInt();
				
				}while (choice == 1);
		scanner.close();
		
	}
	
	}