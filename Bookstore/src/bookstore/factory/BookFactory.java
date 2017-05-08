package bookstore.factory;

import bookstore.model.Book;
import bookstore.model.Person;

public class BookFactory extends AbstractFactory{

	@Override
	public Person getPersonType(String person){
		return null;
	}
	
	@Override
	public Book getBookType(String book){
		if(book == null)
			return null;
		if(book.equalsIgnoreCase("BOOK"))
			return new Book();
		
		return null;
	}

}