package com.bookapp.util;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.bookapp.model.Book;
@Component
public class BookUtil {
	
	public List<Book> getAllBooks() {
		return Arrays.asList(
				new Book("Java in Action",1,"Kathy","Tech",900),
				new Book("Spring Action",2,"john", "Tech",1200),
				new Book("5am Club",3,"Robin", "SelfHelp", 450),
				new Book("HeadFirst JSP",4,"Kathy", "Tech",1090),
				new Book("Java for dummies",5,"Kevin", "Tech",1100),
				new Book("Secred",6,"Rhonda", "Selfhelp",780),
				new Book("Leadership",7,"Robin","Selfhelp",550)		
				);	
	}
}
