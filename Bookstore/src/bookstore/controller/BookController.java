package bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookstore.dao.BookDAO;
import bookstore.factory.AbstractFactory;
import bookstore.factory.FactoryProducer;
import bookstore.model.Book;



@Controller
public class BookController {
	
	
	AbstractFactory bookFactory = FactoryProducer.getFactory("BOOK");

	
	 @Autowired
	    private BookDAO bookDAO;
	 
	    @RequestMapping("/listBook")
	    public ModelAndView handleRequest() throws Exception {
	        List<Book> listBook = bookDAO.list();
	        ModelAndView model = new ModelAndView("listBook");
	        model.addObject("bookList", listBook);
	        return model;
	    }
	     
	    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
	    public ModelAndView newBook() {
	        ModelAndView model = new ModelAndView("BookForm");
	        
	        Book book = bookFactory.getBookType("BOOK");
	        
	        model.addObject("book", book);
	        return model;      
	    }
	     
	    @RequestMapping(value = "/editBook", method = RequestMethod.GET)
	    public ModelAndView editBook(HttpServletRequest request) {
	        int bookId = Integer.parseInt(request.getParameter("idBook"));
	        Book book = bookDAO.getIdBook(bookId);
	        ModelAndView model = new ModelAndView("BookForm");
	        model.addObject("book", book);
	        return model;      
	    }
	     
	    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	    public ModelAndView deleteBook(HttpServletRequest request) {
	        int bookId = Integer.parseInt(request.getParameter("idBook"));
	        bookDAO.delete(bookId);
	        return new ModelAndView("redirect:/listBook");     
	    }
	     
	    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	    public ModelAndView saveBook(@ModelAttribute Book book) {
	        bookDAO.saveOrUpdate(book);
	        return new ModelAndView("redirect:/listBook");
	    }   

}
