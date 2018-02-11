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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/source/css/core/login.css">
</head>
<body>
<s:debug/>
<%--<s:debug/>--%>
<div class="login_box">
    <div class="login_l_img"><img src="${pageContext.request.contextPath}/source/image/login-img.png"></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="${pageContext.request.contextPath}/source/image/login_logo.png"></a></div>
        <div class="login_name">
            <p>人力资源管理系统</p>
        </div>
        <s:form method="POST" action="core_login">
            <s:property value="[0]['errorMessage']"/>
            <s:textfield label="user" name="user" onfocus="this.value=''" onblur="if(this.value===''){this.value='用户名'}" type="text" value="用户名"/>
            <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();">密码</span>
            <s:password label="passwd" name="passwd"  id="password" style="display:none;" onblur="if(this.value===''){document.getElementById('password_text').style.display='block';this.style.display='none'}" />
            <s:submit style="width:100%;" value="提交" />
        </s:form>
    </div>
    <div class="copyright">wami有限公司 版权所有©2016-2018 技术支持电话：18868102765</div>
</div>
</body>
</html>
