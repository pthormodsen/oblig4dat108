<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table>
        <tr>
            <th>Kjønn</th>
            <th align="left">Navn</th>
            <th align="left">Mobil</th>
        </tr>
        <c:forEach var="d" items="${deltagere}">
            <tr>
                <td align="center">
                    <c:choose>
                        <c:when test="${d.kjonn == 'kvinne'}">&#9792;</c:when>
                        <c:otherwise>&#9794;</c:otherwise>
                    </c:choose>
                </td>
                <td>${d.fornavn} ${d.etternavn}</td>
                <td>${d.mobil}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>