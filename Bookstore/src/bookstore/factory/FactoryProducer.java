package bookstore.factory;


public class FactoryProducer {
	 public static AbstractFactory getFactory(String choice){
		   
	      if(choice.equalsIgnoreCase("PERSON")){
	         return new PersonFactory();
	         
	      }else if(choice.equalsIgnoreCase("BOOK")){
	         return new BookFactory();
	      }
	      
	      return null;
	   }

}
