package bookstore.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bookstore.dao.LoginDAO;
import bookstore.dao.ManagerDAO;
import bookstore.dao.UserDAO;
import bookstore.model.Login;


@Controller
public class LoginController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ManagerDAO managerDAO;
	
	@Autowired
	LoginDAO loginDAO;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showLoginPage(ModelAndView model) throws IOException{
		
		model.setViewName("home");
		
		return model;
		
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView handleUserLogin(ModelAndView model,@RequestParam String username,
			@RequestParam String password) throws IOException{
		

		model.addObject("username",username);
		model.addObject("password", password);
		
	//	Login login = new Login(username,password);
	//	loginDAO.addEntry(login);
		
		if(managerDAO.validManager(username,password)){
			model.setViewName("redirect:/homeAdmin");	
			model.addObject("user","Admin");
			return model;
		}
		else{
			if(userDAO.validUser(username,password)){
				model.setViewName("redirect:/homeUser");
				model.addObject("user","User");
				return model;
			}

		else{
					model.addObject("errorMessage", "Invalid username or password");
					model.setViewName("home");
					
					return model;
				}
					}
			
		//return model;
	}

}
