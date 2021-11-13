<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 13/11/2021
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    @-webkit-keyframes my {
        0% { color: #0af822; }
        50% { color: #fff;  }
        100% { color: #0af822;  }
    }
    @-moz-keyframes my {
        0% { color: #0af822;  }
        50% { color: #fff;  }
        100% { color: #0af822;  }
    }
    @-o-keyframes my {
        0% { color: #0af822; }
        50% { color: #fff; }
        100% { color: #0af822;  }
    }
    @keyframes my {
        0% { color: #0af822;  }
        50% { color: #fff;  }
        100% { color: #0af822;  }
    }
    .test {
        background: #ffffff;
        font-size:24px;
        font-weight:bold;
        -webkit-animation: my 700ms infinite;
        -moz-animation: my 700ms infinite;
        -o-animation: my 700ms infinite;
        animation: my 700ms infinite;
    }
</style>
<head>
    <title>Edit Book</title>
</head>
<body>
<center>
    <h1><a href="/books" style="border: none; color: red; text-decoration: none">BOOK MANAGER</a></h1>
</center>
<div align="center">
    <form method="post">
        <caption>
            <h2>Edit Book</h2>
        </caption>
        <table border="1" cellpadding="5">
            <tr>
                <th>Name Book:</th>
                <td><input type="text" name="nameBook" size="45" value="${book.nameBook}"></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="text" name="price" size="45" value="${book.price}"></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td><input type="text" name="description" size="45" value="${book.description}"></td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="category">
                        <option selected="selected">${book.getCategory().nameCategory}</option>
                        <c:forEach items="${category}" var="c">
                            <c:if test="${c.nameCategory != book.getCategory().nameCategory}">
                                <option value="${c.id}">${c.nameCategory}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>
    <p class="test">
        <c:if test="${message!= null}">
            <span>${message}</span>
        </c:if>
    </p>
</div>
</body>
</html>
