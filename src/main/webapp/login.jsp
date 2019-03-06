<%@ page import="net.wanho.entity.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/20
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/login" method="post">
        <input type="text" name="account" value="zhangli"/>
        <input type="password" name="passwd" value="123"/>
        <input type="submit" value="登录" />
    </form>

    <%--<% request.setAttribute("user",new User()); %>--%>

    <%--<form:form modelAttribute="user" action="/user/login">--%>
        <%--<fieldset>--%>
                <%--<label>name:</label>--%>
                <%--<form:input path="account" />--%>
                <%--<form:errors path="account" cssStyle="color:red"/>--%>

                <%--<label>passwd:</label>--%>
                <%--<form:input path="passwd" />--%>
                <%--<form:errors path="passwd" cssStyle="color:red"/>--%>

        <%--<input type="submit" value="login" />--%>
    <%--</form:form>--%>
</body>
</html>
