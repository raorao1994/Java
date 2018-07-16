package SpringDAO.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import SpringDAO.Model.User;

public class UserMappingSqlQuery extends MappingSqlQuery {

	@Override
	protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO 自动生成的方法存根
		User user=new User();
		user.setUserId((Integer)rs.getInt("id"));
		 user.setName((String)rs.getString("name"));
         user.setMoney((Float)rs.getFloat("money"));
		return user;
	}

}
