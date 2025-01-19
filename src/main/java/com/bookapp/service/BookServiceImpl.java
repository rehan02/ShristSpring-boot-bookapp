package com.bookapp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookUtil;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private BookUtil bookUtil;
	
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bookUtil.getAllBooks();
	}
	
	
	@Override
	public List<Book> getByAuthor(String author) {
		// get the list of the books
		List<Book> books=bookUtil.getAllBooks();
		//create a temp list
		List<Book> booksByAuthor = new ArrayList<>();
		
		//iterate through the list
		for (Book book:books) {		
				//check if this books author matches the author from the parameter
				if( book.getAuthor().equals(author) ) 
					//add the book to temporary list
						booksByAuthor.add(book);
			}	
				if (booksByAuthor.isEmpty())
					throw new BookNotFoundException("book with this author not found");
				return booksByAuthor;		
		}
		

	@Override
	public List<Book> getByCategory(String category) {
		// get the list of the books
		List<Book> books=bookUtil.getAllBooks();
		//create a temp list
		List<Book> booksByCategory = new ArrayList<>();
		
		//iterate through the list
		for (Book book:books) {		
				//check if this books category matches the author from the parameter
				if( book.getCategory().equals(category) ) 
					//add the book to temporary list
						booksByCategory.add(book);
			}	
				if (booksByCategory.isEmpty())
					throw new BookNotFoundException("book with this category not found");
				return booksByCategory;
	}

	@Override
	public List<Book> getByLesserPrice(String author, double price) {
		//get the list of ofo books
		List<Book> books=bookUtil.getAllBooks();
		//convert list to stream and filter based on price		
		List<Book> bookByAuthPrice = books.stream()
			 .filter(book->book.getAuthor().equals(author)&&
					book.getPrice()<price)
			 //to convert stream to a list
			 .collect(Collectors.toList());
		if (bookByAuthPrice.isEmpty())
			throw new BookNotFoundException("book with this lesser price not found");
		return bookByAuthPrice;
		
	}

	@Override
	public List<Book> getByTitleStarting(String choice) {
		//get the list of of books
		List<Book> books=bookUtil.getAllBooks();
		//convert list to stream and filter based on title		
				List<Book> bookByTitle = books.stream()
						.filter( book->book.getTitle().startsWith(choice)) 
						 //to convert stream to a list
						 .collect(Collectors.toList());
		if (bookByTitle.isEmpty())
			throw new BookNotFoundException("book with this title not found");
		return bookByTitle;
	}

	@Override
	public Book getById(int bookId) {
//		// get the list of the books
//		List<Book> books=bookUtil.getAllBooks();	
//		//iterate through the list
//		for (Book book:books) {
//			//check if this book id matches the author from the bookId from the  parameter	
//		if( book.getBookId()==bookId)) {
//			return book;
//		}
		
//		return null;

//		// 2nd way
//		List<Book> books=bookUtil.getAllBooks();
//		//convert list to stream and filter based on title		
//		Optional<Book> bookOpt=	 books.stream()
//			 .filter(book->book.getBookId()==bookId)
//			 .findFirst();		 
//		if(bookOpt.isPresent())
//			return bookOpt.get();
//		return null;
		
		// 3rd way
		List<Book> books=bookUtil.getAllBooks();
		//convert list to stream and filter based on title
		return books.stream()
		 	.filter(book->book.getBookId()==bookId)
		 	.findFirst()
		 	.orElseThrow(()-> new BookNotFoundException("Invalid id") );
	}
	}