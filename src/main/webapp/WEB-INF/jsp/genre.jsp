<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Genre cd</title>
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
    Genre cd
</h1>
<c:url var="addAction" value="/genres/add-genre"></c:url>

<form:form action="${addAction}" modelAttribute="genre" form="">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="Id"/>
                </form:label>
            </td>
            <td>
                <form:input  path="id"/>
            </td>
        </tr>

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
                <form:label path="numGenre">
                    <spring:message text="Num genre"/>
                </form:label>
            </td>
            <td>
                <form:input path="numGenre"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Add Genre"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listGenreCd}">
    <table class="tg">
        <tr>
            <th width="40">Id</th>
            <th width="40">Num cd</th>
            <th width="40">Num genre</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listGenreCd}" var="genre">
            <tr>
                <td>${genre.id}</td>
                <td>${genre.numCd}</td>
                <td>${genre.numGenre}</td>

                <td><a href="<c:url value="/edit-genre/${genre.id}" />">Edit</a></td>
                <td><a href="<c:url value="/delete-genre/${genre.id}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>