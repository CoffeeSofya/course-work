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
    Renter
</h1>
<c:url var="addAction" value="/renters/add-renter" ></c:url>

<form:form action="${addAction}" modelAttribute="renter" form="">
    <table>

        <tr>
            <td>
                <form:label path="numRenter">
                    <spring:message text="Number renter"/>
                </form:label>
            </td>
            <td>
                <form:input path="numRenter"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="fullName">
                    <spring:message text="Full name"/>
                </form:label>
            </td>
            <td>
                <form:input path="fullName" id="fullName"/>

                <form:label path="fullName">
                    <spring:message text="Это обязательное поле"/>
                </form:label>
<%--                <form:errors path="fullName"/>--%>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="tel">
                    <spring:message text="Tel"/>
                </form:label>
            </td>
            <td>
                <form:input path="tel"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Add Renter"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listRenter}">
    <table class="tg">
        <tr>
            <th width="40">Number renter</th>
            <th width="200">Full name</th>
            <th width="80">Tel</th>
            <th width="80">Email</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listRenter}" var="renter">
            <tr>
                <td>${renter.numRenter}</td>
                <td>${renter.fullName}</td>
                <td>${renter.tel}</td>
                <td>${renter.email}</td>

                <td><a href="<c:url value="/edit-renter/${renter.numRenter}" />">Edit</a></td>
                <td><a href="<c:url value="/delete-renter/${renter.numRenter}" />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>