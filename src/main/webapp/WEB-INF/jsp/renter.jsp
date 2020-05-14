<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Renter</title>
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
    Renter
</h2>
<c:url var="addAction" value="/renters/add-renter" ></c:url>

<form:form action="${addAction}" modelAttribute="renter" form="">
    <table>

        <tr>
            <td>
                <form:label path="numRenter">
                    <spring:message text="№ клиента"/>
                </form:label>
            </td>
            <td>
                <form:input path="numRenter" maxlength="10"/>
                <form:errors path="numRenter" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="fullName">
                    <spring:message text="ФИО"/>
                </form:label>
            </td>
            <td>
                <form:input path="fullName" maxlength="100"/>
                <form:errors path="fullName" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="tel">
                    <spring:message text="Телефон"/>
                </form:label>
            </td>
            <td>
                <form:input path="tel" maxlength="12"/>
                <form:errors path="tel" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email" maxlength="50"/>
                <form:errors path="email" />
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
<c:if test="${!empty listRenter}">
    <table class="tg">
        <tr>
            <th>№ клиента</th>
            <th>ФИО</th>
            <th>Телефон</th>
            <th>Email</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
        <c:forEach items="${listRenter}" var="renter">
            <tr>
                <td>${renter.numRenter}</td>
                <td>${renter.fullName}</td>
                <td>${renter.tel}</td>
                <td>${renter.email}</td>

                <td><a href="<c:url value="/edit-renter/${renter.numRenter}" />">Редактировать</a></td>
                <td><a href="<c:url value="/delete-renter/${renter.numRenter}" />">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>