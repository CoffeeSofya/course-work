<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CD</title>
    <style type="text/css">
        .tg {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
            text-align: center;
        }
        .tgb .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>
    CD
</h1>
<c:url var="addAction" value="/cds/add-cd"></c:url>

<form:form action="${addAction}" modelAttribute="cd" form="">
    <table>

        <tr>
            <td>
                <form:label path="numCd">
                    <spring:message text="Number cd"/>
                </form:label>
            </td>
            <td>
                <form:input path="numCd"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="releaseYear">
                    <spring:message text="Release year"/>
                </form:label>
            </td>
            <td>
                <form:input path="releaseYear"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="cost">
                    <spring:message text="Cost cd"/>
                </form:label>
            </td>
            <td>
                <form:input path="cost"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="count">
                    <spring:message text="Count cd"/>
                </form:label>
            </td>
            <td>
                <form:input path="count"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Add CD"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listCD}">
    <table class="tg">
        <tr>
            <th width="40">Number cd</th>
            <th width="200">Title</th>
            <th width="80">Release year</th>
            <th width="80">Cost cd</th>
            <th width="80">Count cd</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listCD}" var="cd">
            <tr>
                <td>${cd.numCd}</td>
                <td>${cd.title}</td>
                <td>${cd.releaseYear}</td>
                <td>${cd.cost}</td>
                <td>${cd.count}</td>

                <td><a href="<c:url value="/edit-cd/${cd.numCd}" />">Edit</a></td>
                <td><a href="<c:url value="/delete-cd/${cd.numCd}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>