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
            padding: 15px 45px;
            border-collapse: collapse;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 15px 10px;
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
        errors{
            font-family: Arial, sans-serif;
            font-size: 12px;
            color: red;
        }
        input{
            padding: 3px 5px;
            border-width: 1px;
            border-color: #ccc;
            border-radius: 2px;
        }
        a{
            text-decoration: none;
            color: rgba(2, 84, 199, 0.78);
        }
        a:hover{
            color: rgb(2, 78, 186);
        }
    </style>
</head>
<body>
<table class="tg">
    <tr>
        <td><a href="<c:url value="/renter" />">Renter</a></td>
        <td><a href="<c:url value="/rental" />">Rental</a></td>
        <td><a href="<c:url value="/cd" />">Cd</a></td>
        <td><a href="<c:url value="/list-genre" />">List genre</a></td>
        <td><a href="<c:url value="/genre" />">Genres</a></td>
    </tr>
</table>
<h2>
    Genre cd
</h2>
<c:url var="addAction" value="/genres/add-genre"></c:url>

<form:form action="${addAction}" modelAttribute="genre" form="">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="№"/>
                </form:label>
            </td>
            <td>
                <form:input  path="id" maxlength="10"/>
                <form:errors path="id" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="numCd">
                    <spring:message text="№ диска"/>
                </form:label>
            </td>
            <td>
                <form:input path="numCd" maxlength="10"/>
                <form:errors path="numCd" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="numGenre">
                    <spring:message text="№ жанра"/>
                </form:label>
            </td>
            <td>
                <form:input path="numGenre" maxlength="10"/>
                <form:errors path="numGenre" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Добавить"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listGenreCd}">
    <table class="tg">
        <tr>
            <th>№</th>
            <th>№ диска</th>
            <th>№ жанра</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${listGenreCd}" var="genre">
            <tr>
                <td>${genre.id}</td>
                <td>${genre.numCd}</td>
                <td>${genre.numGenre}</td>

                <td><a href="<c:url value="/edit-genre/${genre.id}" />">Редактировать</a></td>
                <td><a href="<c:url value="/delete-genre/${genre.id}" />">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>