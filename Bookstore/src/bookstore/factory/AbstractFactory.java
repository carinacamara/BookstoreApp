package bookstore.factory;

import bookstore.model.Book;
import bookstore.model.Person;

public abstract class AbstractFactory {
	
	public abstract Person getPersonType(String person);
	public abstract Book getBookType(String book);

}
