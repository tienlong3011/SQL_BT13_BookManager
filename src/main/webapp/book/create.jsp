<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 13/11/2021
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New Book</title>
</head>
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
<body>
<center>
    <h1><a href="/books" style="border: none; color: red; text-decoration: none">BOOK MANAGER</a></h1>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add new Book</h2>
            </caption>
            <tr>
                <th>Name Book:</th>
                <td><input type="text" name="nameBook" placeholder="Nhập tên sách" size="45"></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="text" name="price" placeholder="Nhập giá" size="45"></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td><input type="text" name="description" placeholder="Mô tả" size="45"></td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="category">
                        <c:forEach items='${requestScope["category"]}' var="c">
                            <option value="${c.id}">${c.nameCategory}</option>
                        </c:forEach>
                    </select>
                </td>

            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
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
