package bookstore.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Logins")
@XmlAccessorType (XmlAccessType.FIELD)
public class Logins {
	
	@XmlElement(name = "login")
	private List<Login> list = null;
	
	
	
	
	public List<Login> getList() {
		return list;
	}




	public void setList(List<Login> list) {
		this.list = list;
	}




	public void addList(List<Login> list){
		this.list.addAll(list);
	}
	
	

}
