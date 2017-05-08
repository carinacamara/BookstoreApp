package bookstore.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Users")
@XmlAccessorType (XmlAccessType.FIELD)
public class Users {
	
	 @XmlElement(name = "user")
	private List<User> list = null;


	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	
	public void addList(List<User> list){
		this.list.addAll(list);
	}
	

}
