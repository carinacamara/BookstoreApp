package bookstore.dao;

import java.util.List;

import bookstore.model.User;


public interface UserDAO {
	
	public List<User> list();
     
    public User get(int idUser);
	     
	public void saveOrUpdate(User user);
	     
    public void delete(int idUser);
    
    public User getUser(String username, String password);
    
    public boolean validUser(String username, String password);

}
