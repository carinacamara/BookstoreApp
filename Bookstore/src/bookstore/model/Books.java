package bookstore.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Books")
@XmlAccessorType (XmlAccessType.FIELD)
public class Books {

	

	 @XmlElement(name = "book")
	private List<Book> list = null;

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	 
	public void addList(List<Book> list){
		this.list.addAll(list);
	}
}
