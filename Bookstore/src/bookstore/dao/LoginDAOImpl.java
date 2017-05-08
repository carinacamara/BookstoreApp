package bookstore.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import bookstore.model.Login;
import bookstore.model.Logins;

public class LoginDAOImpl implements LoginDAO{
	
	File file =new File("/home/carina/Documents/workspace-sts-3.8.3.RELEASE/Bookstore/src/bookstore/model/Login.xml");

	Logins logins = new Logins();
	
	@Override
	public void addEntry(Login login){
		
		try{
 		   
		    JAXBContext jaxbContext = JAXBContext.newInstance(Logins.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    logins.getList().add(login);
		    jaxbMarshaller.marshal(logins, file);
		    
		    	}catch(JAXBException e){
		    		e.printStackTrace();
		    	}
	}

	
	@Override
	public Login getLast(){
	
		
		return null;
	}

}
