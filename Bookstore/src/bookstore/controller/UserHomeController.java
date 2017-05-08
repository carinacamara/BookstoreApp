package bookstore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bookstore.dao.BookDAO;
import bookstore.model.Book;




@Controller
public class UserHomeController {
	
	@Autowired
	BookDAO bookDAO;
	

	
	@RequestMapping(value="/homeUser")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<Book> listBook = bookDAO.list();
		bookDAO.createPDF();
		model.addObject("listBook", listBook);
		model.setViewName("homeUser");
		
		return model;
	}
	
	//pagina unde cerem titlul
	@RequestMapping(value = "/searchTitle", method = RequestMethod.GET)
	public ModelAndView showTitle(ModelAndView model) throws IOException{
		
		model.setViewName("TitleForm");
		
		return model;
	}
	
	// pagina pe care afisam cartile cu titlul ala
	@RequestMapping(value="/listTitle")
	public ModelAndView listTitle(ModelAndView model, @RequestParam String title) throws IOException{
		
		model.addObject("title",title);
	
		
		List<Book> listBook = bookDAO.getTitle(title);
		
		model.addObject("listBook", listBook);
		model.setViewName("listTitle");
		
		return model;
	}
	
	//pagina unde cerem autorul
		@RequestMapping(value = "/searchAuthor", method = RequestMethod.GET)
		public ModelAndView showAuthor(ModelAndView model) throws IOException{
			
			model.setViewName("AuthorForm");
			
			return model;
		}
		
		// pagina pe care afisam cartile cu autorul ala
		@RequestMapping(value="/listAuthor")
		public ModelAndView listAuthor(ModelAndView model, @RequestParam String author) throws IOException{
			
			model.addObject("author",author);
		
			
			List<Book> listBook = bookDAO.getAuthor(author);
			
			model.addObject("listBook", listBook);
			model.setViewName("listAuthor");
			
			return model;
		}
		
		//pagina unde cerem gender
		@RequestMapping(value = "/searchGender", method = RequestMethod.GET)
		public ModelAndView showGender(ModelAndView model) throws IOException{
			
			model.setViewName("GenderForm");
			
			return model;
		}
		
		// pagina pe care afisam cartile cu gender ala
		@RequestMapping(value="/listGender")
		public ModelAndView listGender(ModelAndView model, @RequestParam String gender) throws IOException{
			
			model.addObject("gender",gender);
		
			
			List<Book> listBook = bookDAO.getGender(gender);
			
			model.addObject("listBook", listBook);
			model.setViewName("listGender");
			
			return model;
		}

		   
	    @RequestMapping(value = "/sellBook", method = RequestMethod.GET)
	    public ModelAndView deleteUser(HttpServletRequest request, ModelAndView model) {
	        int idBook = Integer.parseInt(request.getParameter("idBook"));
	        List<Book> listBook = bookDAO.sell(idBook);
			model.addObject("listBook", listBook);
			model.setViewName("homeUser");
			
			return model;     
	    }
}
