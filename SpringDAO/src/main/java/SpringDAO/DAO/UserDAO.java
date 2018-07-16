package SpringDAO.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import SpringDAO.IDAO.IUserDAO;
import SpringDAO.Model.User;

public class UserDAO extends JdbcDaoSupport implements IUserDAO{

	public List<User> QueryAllUser() {
		// TODO 自动生成的方法存根
		
		String sql="select * from user";
		List<Map<String,Object>> list=getJdbcTemplate().queryForList(sql);
		List<User> userlist=new ArrayList<User>();
		for(Map<String,Object> row:list)
		{
			User user=new User();
            user.setUserId((Integer)row.get("id"));
            user.setName((String)row.get("name"));
            user.setMoney((Float)row.get("money"));
            userlist.add(user);
		}
		return userlist;
	}
	
	public List<User> QueryAllUser(String name)
	{
		String sql="select * from user";
		UserMappingSqlQuery query=new UserMappingSqlQuery();
		query.setDataSource(getDataSource());
		query.setSql(sql);
		query.compile();
		return query.execute();
	}

	public Boolean AddUser(String name, float money) {
		// TODO 自动生成的方法存根
		
		String sql="insert into user (name,money) values(?,?)";
		int row=getJdbcTemplate().update(sql,new Object[]{name,money});
		return row>0?true:false;
	}
	
	

}
