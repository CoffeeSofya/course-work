<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List genre</title>
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
    List genre
</h1>
<c:url var="addAction" value="/list-genres/add-list-genre"></c:url>

<form:form action="${addAction}" modelAttribute="list-genre" form="">
    <table>

        <tr>
            <td>
                <form:label path="numGenre">
                    <spring:message text="Number genre"/>
                </form:label>
            </td>
            <td>
                <form:input path="numGenre"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="genre">
                    <spring:message text="Genre"/>
                </form:label>
            </td>
            <td>
                <form:input path="genre"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Add List genre"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listListGenre}">
    <table class="tg">
        <tr>
            <th width="40">Number genre</th>
            <th width="200">Genre</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listListGenre}" var="list_genre">
            <tr>
                <td>${list_genre.numGenre}</td>
                <td>${list_genre.genre}</td>

                <td><a href="<c:url value="/edit-list-genre/${list_genre.numGenre}" />">Edit</a></td>
                <td><a href="<c:url value="/delete-list-genre/${list_genre.numGenre}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>