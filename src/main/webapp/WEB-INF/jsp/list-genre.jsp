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
        .top{
            display: flex;
            margin-bottom: 10px;
        }
        .item{
            margin-right: 20px;
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
    List genre
</h2>
<c:url var="addAction" value="/list-genre/add-list-genre"></c:url>

<div class="top">
    <div class="item">
        <form:form action="${addAction}" modelAttribute="list-genre" form="">
            <table>
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
                    <td>
                        <form:label path="genre">
                            <spring:message text="Жанр"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="genre" maxlength="30"/>
                        <form:errors path="genre" />
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
    </div>

    <div class="item">
        <c:if test="${!empty listgenres}">
            <table class="tg">
                <tr>
                    <th>№ диска</th>
                    <th>Название</th>
                    <th>Год выпуска</th>
                    <th>Стоимость</th>
                    <th>Количество</th>
                </tr>
                <c:forEach items="${listgenres}" var="l">
                    <tr>
                        <td>${l.numCd}</td>
                        <td>${l.title}</td>
                        <td>${l.releaseYear}</td>
                        <td>${l.cost}</td>
                        <td>${l.count}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>

<c:if test="${!empty listListGenre}">
    <table class="tg">
        <tr>
            <th>№ жанра</th>
            <th>Жанр</th>
            <th>Редактировать</th>
            <th>Удалить</th>
            <th>Показать диски</th>
        </tr>
        <c:forEach items="${listListGenre}" var="list_genre">
            <tr>
                <td>${list_genre.numGenre}</td>
                <td>${list_genre.genre}</td>

                <td><a href="<c:url value="/edit-list-genre/${list_genre.numGenre}" />">Редактировать</a></td>
                <td><a href="<c:url value="/delete-list-genre/${list_genre.numGenre}" />">Удалить</a></td>
                <td><a href="<c:url value="/get-list-cd/${list_genre.numGenre}" />">Показать диски</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>