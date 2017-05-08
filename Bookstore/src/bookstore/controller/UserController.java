package bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookstore.dao.UserDAO;
import bookstore.factory.AbstractFactory;
import bookstore.factory.FactoryProducer;
import bookstore.model.Person;
import bookstore.model.User;

@Controller
public class UserController {

	AbstractFactory personFactory = FactoryProducer.getFactory("PERSON");
	
	 	@Autowired
	    private UserDAO userDao;
	 
	    @RequestMapping("/homeAdmin")
	    public ModelAndView handleRequest() throws Exception {
	        List<User> listUsers = userDao.list();
 
	        ModelAndView model = new ModelAndView("homeAdmin");
	        model.addObject("userList", listUsers);
	        return model;
	    }
	     
	    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
	    public ModelAndView newUser() {
	        ModelAndView model = new ModelAndView("UserForm");
	        
	        Person user = personFactory.getPersonType("USER");
	        
	        model.addObject("user", user);
	        return model;      
	    }
	     
	    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
	    public ModelAndView editUser(HttpServletRequest request) {
	        int userId = Integer.parseInt(request.getParameter("idUser"));
	        User user = userDao.get(userId);
	        ModelAndView model = new ModelAndView("UserForm");
	        model.addObject("user", user);
	        return model;      
	    }
	     
	    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	    public ModelAndView deleteUser(HttpServletRequest request) {
	        int userId = Integer.parseInt(request.getParameter("idUser"));
	        userDao.delete(userId);
	        return new ModelAndView("redirect:/homeAdmin");     
	    }
	     
	    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	    public ModelAndView saveUser(@ModelAttribute User user) {
	        userDao.saveOrUpdate(user);
	        return new ModelAndView("redirect:/homeAdmin");
	    }   
}
