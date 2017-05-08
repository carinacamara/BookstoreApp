package bookstore.dao;

import bookstore.model.Login;

public interface LoginDAO {

	public void addEntry(Login login);
	public Login getLast();
}
