<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wammi
  Date: 2018/2/6
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/source/css/core/index.css">
</head>
<body>
<div class="head">
    <div class="headleft">

    </div>
    <div class="headmiddle">
        <div class>

        </div>
        <div class>

        </div>
    </div>
    <div class="headright">
        <div>

        </div>
        <div>

        </div>
    </div>
</div>
<div class="area">
    <div class="leftarea">
        <s:iterator var="temp" value="privNodeTree">
            <s:property value='key["midelName"]'/>
            <s:iterator value="value" var="id" >
                <s:property value="#id.interfaceName"/>
            </s:iterator>
        </s:iterator>
        <s:debug/>
    </div>
    <div class="rightarea">
        <div>

        </div>
        <div class="bottom">
            <div>

            </div>
            <div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
