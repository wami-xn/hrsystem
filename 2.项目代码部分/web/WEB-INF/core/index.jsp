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
</head>
<body>
<body>
<%--<s:iterator value="[0]['errormessage']" var="map">
    <s:iterator value="map" var="button"/>
</s:iterator>--%>
<s:iterator var="temp" value="privNodeTree">
    <s:property value='key["midelName"]'/>
    <s:iterator value="value" var="id" >
        <s:property value="#id.interfaceName"/>
    </s:iterator>
</s:iterator>
<s:debug/>

</body>
</body>
</html>
