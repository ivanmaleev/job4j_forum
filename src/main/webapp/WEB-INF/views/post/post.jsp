<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
    <tr>
        <td>Название:</td>
        <td>${post.name}</td>
    </tr>
    <tr>
        <td>Описание:</td>
        <td>${post.description}</td>
    </tr>
    <tr>
        <td>Создано:</td>
        <td>${post.created}</td>
    </tr>
</table>
</body>
</html>