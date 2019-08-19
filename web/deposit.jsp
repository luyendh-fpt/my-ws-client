<%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-08-19
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Deposit Form</h1>
    <form action="/deposit" method="post">
        <div>
            Username <input type="text" name="username">
        </div>
        <div>
            Password <input type="password" name="password">
        </div>
        <div>
            Balance ($) <input type="number" name="balance">
        </div>
        <div>
            Content <input type="text" name="content">
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </form>
</body>
</html>
