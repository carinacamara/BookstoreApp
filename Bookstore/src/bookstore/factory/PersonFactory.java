package bookstore.factory;

import bookstore.model.Book;
import bookstore.model.Person;
import bookstore.model.User;

public class PersonFactory extends AbstractFactory {
	
	@Override
	public Person getPersonType(String person){
	
		if(person == null)
			return null;
		
		if(person.equalsIgnoreCase("USER"))
	         return new User();
	
		return null;
	}

		@Override
		public Book getBookType(String book){
			return null;
		}

}