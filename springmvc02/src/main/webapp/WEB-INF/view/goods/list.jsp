<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品列表</title>
<style >
</style>
</head>
<body>
	<h1>商品列表</h1>
	用户名： ${list.size()}条数据<br>
<table>
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>price</th>
                <th>picture</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.id}</<td>
                        <td>${item.name}</<td>
                        <td>${item.price}</<td>
                        <td>${item.picture}</<td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>