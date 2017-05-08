package bookstore.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import bookstore.model.User;
import bookstore.model.Users;

public class UserDAOImpl implements UserDAO {
	
	File file =new File("/home/carina/Documents/workspace-sts-3.8.3.RELEASE/Bookstore/src/bookstore/model/User.xml");

	static Users users = new Users();
	
	static{
	   
	users.setList(new ArrayList<User>());
	
	User usr1 = new User();
	usr1.setIdUser(1);
	usr1.setName("Carina");
	usr1.setUsername("employeeCarina");
	usr1.setPassword("password");
	usr1.setEmail("carina@sql.com");
	
	User usr2 = new User();
	usr2.setIdUser(2);
	usr2.setName("Aida");
	usr2.setUsername("employeeAida");
	usr2.setPassword("password");
	usr2.setEmail("aida@sql.com");
	
	users.getList().add(usr1);
	users.getList().add(usr2);
	
    
	}
	
	@Override
	public List<User> list() {


		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    //We had written this file in marshalling example
	    Users usr = (Users) jaxbUnmarshaller.unmarshal(file);
	    

	    List<User> newList = new ArrayList<User>(usr.getList());
	    return newList;
	    
		}catch(JAXBException e){
    		e.printStackTrace();
    	}

		return null;
		
	}

	@Override
	public void saveOrUpdate(User user) {
		
	
		try{
    		   
		    JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    users.getList().add(user);
		    jaxbMarshaller.marshal(users, file);
		    
		    	}catch(JAXBException e){
		    		e.printStackTrace();
		    	}
		    
	}
	
	@Override
	 public void delete(int idUser){	

		List<User> found = new ArrayList<User>();
		for(User user : users.getList()){
		    if(user.getIdUser() == idUser){
		        found.add(user);
		    }
		}
		users.getList().removeAll(found);
		
		
		InputSource source = null;
		try {
			source = new InputSource(new FileInputStream(file));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		XPathFactory builder = XPathFactory.newInstance();
		XPath xpath = builder.newXPath();

		XPathExpression exp = null;
		try {
			exp = xpath.compile("Users/user[idUser=" + idUser +"]");
		} catch (XPathExpressionException e1) {
			e1.printStackTrace();
		}

		Node node = null;
		try {
			node = (Node) exp.evaluate(source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		node.getParentNode().removeChild(node);
		
		try{
 		   
		    JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    jaxbMarshaller.marshal(users, file);
		    
		    	}catch(JAXBException e){
		    		e.printStackTrace();
		    	}
		    
		
	}
	
	@Override
    public User get(int idUser){
	
    	return null;
    }
	
	@Override
	public User getUser(String username, String password){
		
		InputSource source = null;
		try {
			source = new InputSource(new FileInputStream(file));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		XPathFactory builder = XPathFactory.newInstance();
		XPath xpath = builder.newXPath();

		XPathExpression exp = null;
		try {
		//	exp = xpath.compile("Users/user[username/text()='" + username + "' and password/text()='"+ password +"']");
			
			exp = xpath.compile("Users/user[name/text()='" + "Carina" + "']/username");

		} catch (XPathExpressionException e1) {
			System.out.println("Eroare la xpath");
			e1.printStackTrace();
		}

		String el = null;
		try {
			el = (String) exp.evaluate(source, XPathConstants.STRING);
			
			System.out.println("Evaluare xpath");

		//	Element el = (Element)node;
			
			
			System.out.println("name"+el);
			
	//		User user = new User(el.getAttribute("name"),el.getAttribute("username"),el.getAttribute("password"),el.getAttribute("email"));
			
				return new User();

				
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return new User();
	}
	
	@Override
	  public boolean validUser(String username, String password){
		
		InputSource source = null;
		try {
			source = new InputSource(new FileInputStream(file));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		XPathFactory builder = XPathFactory.newInstance();
		XPath xpath = builder.newXPath();

		XPathExpression exp = null;
		try {
			exp = xpath.compile("Users/user[username/text()='" + username + "' and password/text()='"+ password +"']");
			
		//	exp = xpath.compile("Users/user[name/text()='" + "Carina" + "']/username");

		} catch (XPathExpressionException e1) {
			System.out.println("Eroare la xpath");
			e1.printStackTrace();
		}

		String el = null;
		try {
			el = (String) exp.evaluate(source, XPathConstants.STRING);
			
			System.out.println("STRING   "+el);
			
			if(el.isEmpty())
				return false;
				
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	
		return true;
	}


}
