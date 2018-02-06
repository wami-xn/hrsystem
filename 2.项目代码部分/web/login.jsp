<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wammi
  Date: 2018/2/5
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<s:form action="core_login.action">
    <s:textarea label="user"/>
    <s:password label="passwd"/>
    <s:submit/>
</s:form>
</body>
</html>
