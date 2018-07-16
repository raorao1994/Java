package SpringDAO.IDAO;

import java.util.List;

import SpringDAO.Model.User;

public interface IUserDAO {
	public List<User> QueryAllUser();
	
	public Boolean AddUser(String name,float money);

	public List<User> QueryAllUser1();
}
