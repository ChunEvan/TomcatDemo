<%--
  Created by IntelliJ IDEA.
  User: huangchun
  Date: 2020/11/10
  Time: 3:37 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="hello.html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        tomcat
    </title>
</head>
<body>
    hello , tomcat

    <%
        int number = 2;
        request.setAttribute("number", number);
        List<String> list = new ArrayList();
        request.setAttribute("number", number);
        request.setAttribute("list", list);
    %>

    <c:if test="${not empty cookie}">true</c:if>

    <c:choose>
        <c:when test="${number==1}"></c:when>
        <c:when test="${number==1}"></c:when>
        <c:when test="${number==1}"></c:when>
        <c:otherwise>123</c:otherwise>

    </c:choose>
    <c:forEach begin="1" end="10" var="i" step="1"  varStatus="s">
        ${i}<br>
    </c:forEach>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str}
    </c:forEach>








    <!--
        hell0, world
    -->

    <%--
        cfsa ds

     --%>

    ${3>4}


    <a href="/demo2">hello demo2</a>
    <%
//        String message = exception.getMessage();
//        List list= new ArrayList();
//        System.out.println("hhhh");
//        request;
//        pageContext;
//        session;
//        application;
//        response;
//        page;
//        out;
//        config;

    %>

    <%="123"%>

    <%!
        int i =0;
    %>

</body>
</html>
