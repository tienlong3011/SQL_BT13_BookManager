
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 13/11/2021
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Book</title>
</head>
<body>
<center>
    <h1><a href="/books" style="border: none; color: red; text-decoration: none" >BOOK MANAGER</a></h1>
    <h2><a href="/books?action=create">Add new Book</a></h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Book</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name Book</th>
            <th>Price</th>
            <th>Description</th>
            <th>Category</th>
            <th>Actions</th>

        </tr>
        <c:forEach items='${requestScope["bookList"]}' var="b">
            <tr>
                <td><c:out value="${b.id}"/></td>
                <td><c:out value="${b.nameBook}"/></td>
                <td><c:out value="${b.price}"/></td>
                <td><c:out value="${b.description}"/></td>
                <td><c:out value="${b.getCategory().nameCategory}"/></td>
                <td>
                    <a href="/books?action=edit&id=${b.id}">Edit</a>
                    <a href="/books?action=delete&id=${b.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
