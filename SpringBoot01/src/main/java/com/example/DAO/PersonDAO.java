package com.example.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.Person;

@Repository
public class PersonDAO {
	
	@Autowired
	JndiTemplate jdbcTemplate;
	
	public void save(Person p)
	{
		String sql="";
		jdbcTemplate.update(sql, p.getName(), p.getAge(),p.getSex());
	}
}
