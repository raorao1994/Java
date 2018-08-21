package com.raorao.ssm.conversionService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DataConverter implements Converter<String,Date> {

	public Date convert(String resource) {
		// TODO 自动生成的方法存根
		SimpleDateFormat simpleDataFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			System.out.println("执行数据转换");
			return simpleDataFormat.parse(resource);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
