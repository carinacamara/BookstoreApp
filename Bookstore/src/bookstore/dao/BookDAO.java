package bookstore.dao;

import java.util.List;

import bookstore.model.Book;

public interface BookDAO {
	
	
		public List<Book> list();
	 
	 	public void saveOrUpdate(Book book);
     
	    public void delete(int idBook);
     
	    public Book getIdBook(int idBook);
	    
	    public List<Book>  getTitle(String title);
	    
	    public List<Book> getAuthor(String author);
	    
	    public List<Book> getGender(String gender);
		     
	    public List<Book> sell(int idBook);
	    
	    public void createPDF();
		

}
