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
        CD
    </h2>
    <c:url var="addAction" value="/cd/add-cd"></c:url>

<div class="top">
    <div class="item">
        <form:form action="${addAction}" modelAttribute="cd" form="">
            <table>

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
                        <form:label path="title">
                            <spring:message text="Название"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="title" maxlength="100"/>
                        <form:errors path="title" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="releaseYear">
                            <spring:message text="Год выпуска"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="releaseYear" maxlength="4"/>
                        <form:errors path="releaseYear" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="cost">
                            <spring:message text="Стоимость"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="cost" maxlength="10"/>
                        <form:errors path="cost" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="count">
                            <spring:message text="Количество"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="count" maxlength="10"/>
                        <form:errors path="count" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="<spring:message text="Добавить"/>"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>

    <div class="item">
    <c:if test="${!empty genres}">
        <table class="tg">
            <tr>
                <th>№</th>
                <th>Жанр</th>
            </tr>
            <c:forEach items="${genres}" var="g">
                <tr>
                    <td>${g.numGenre}</td>
                    <td>${g.genre}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    </div>
</div>

<c:if test="${!empty listCD}">
    <table class="tg">
        <tr>
            <th>№ диска</th>
            <th>Название</th>
            <th>Год выпуска</th>
            <th>Стоимость</th>
            <th>Количество</th>
            <th>Редактировать</th>
            <th>Удалить</th>
            <th>Показать жанры</th>
        </tr>
        <c:forEach items="${listCD}" var="cd">
            <tr>
                <td>${cd.numCd}</td>
                <td>${cd.title}</td>
                <td>${cd.releaseYear}</td>
                <td>${cd.cost}</td>
                <td>${cd.count}</td>

                <td><a href="<c:url value="/edit-cd/${cd.numCd}" />">Редактировать</a></td>
                <td><a href="<c:url value="/delete-cd/${cd.numCd}" />">Удалить</a></td>
                <td><a href="<c:url value="/get-genres/${cd.numCd}" />">Показать жанры</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>