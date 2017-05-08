package bookstore.dao;


public class ManagerDAOImpl implements ManagerDAO {


	@Override
	public boolean validManager(String username, String password) {
		return username.equalsIgnoreCase("root") && password.equals("root");
	}

}
