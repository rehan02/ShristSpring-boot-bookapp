package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBootBookappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookappApplication.class, args);
	}
	
	@Autowired
	private IBookService bookService;
	@Override
	public void run (String...  args) throws Exception {
		bookService.getAll().forEach(System.out::println);
		System.out.println();
		System.out.println("By Author");
		bookService.getByAuthor("Robin").forEach(System.out::println);
		
		System.out.println();
		System.out.println("By Category");
		bookService.getByCategory("Tech").forEach(System.out::println);
		
		System.out.println();
		System.out.println("By Title Starting");
		bookService.getByTitleStarting("J").forEach(System.out::println);
		
		System.out.println();
		System.out.println("By Lesser price");
		bookService.getByLesserPrice("Kathy",1300).forEach(System.out::println);
		
		System.out.println();
		System.out.println("By Id");
		Book book = bookService.getById(2);
		System.out.println(book);
	}
}
