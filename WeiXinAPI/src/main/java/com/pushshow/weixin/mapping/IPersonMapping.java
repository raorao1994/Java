package com.pushshow.weixin.mapping;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.pushshow.weixin.entity.*;

public interface IPersonMapping {
	
	@Insert("insert into person (name,age,sex) values(#{name},#{age},#{sex})")
	int add(@Param("name")String name,@Param("age")int age,@Param("sex")boolean sex);
	
	@Select("select * from person where id=#{id}")
	Person getentity(@Param("id")int id);
}
