<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rental</title>
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
    Rental
</h1>
<c:url var="addAction" value="/rental/add-rental"></c:url>

<form:form action="${addAction}" modelAttribute="rental" form="">
    <table>

        <tr>
            <td>
                <form:label path="numRental">
                    <spring:message text="Number rental"/>
                </form:label>
            </td>
            <td>
                <form:input path="numRental"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="numCd">
                    <spring:message text="Num cd"/>
                </form:label>
            </td>
            <td>
                <form:input path="numCd"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="numRenter">
                    <spring:message text="Num renter"/>
                </form:label>
            </td>
            <td>
                <form:input path="numRenter"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dateRental">
                    <spring:message text="Date rental"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateRental"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Add Rental"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listRental}">
    <table class="tg">
        <tr>
            <th width="40">Number rental</th>
            <th width="40">Num cd</th>
            <th width="40">Num renter</th>
            <th width="80">Date rental</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listRental}" var="rental">
            <tr>
                <td>${rental.numRental}</td>
                <td>${rental.numCd}</td>
                <td>${rental.numRenter}</td>
                <td>${rental.dateRental}</td>

                <td><a href="<c:url value="/edit-rental/${rental.numRental}" />">Edit</a></td>
                <td><a href="<c:url value="/delete-rental/${rental.numRental}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>