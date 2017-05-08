package bookstore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "User")
@XmlAccessorType (XmlAccessType.FIELD)
public class User extends Person{
	

	private int idUser;
	
	private String name;
	private String username;
	private String password;
	private String email;

	
	public User(){}

	public User(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getIdUser() {
		return idUser;
	}

//	@XmlAttribute(name = "idUser")
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

//	@XmlElement(name = "username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

//	@XmlElement(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

//	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

//	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	


}
