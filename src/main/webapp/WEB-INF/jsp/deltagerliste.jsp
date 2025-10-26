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
    <form action="logout" method="post" style="margin-bottom: 10px;">
        <button type="submit">Logg ut</button>
    </form>
    <p>Innlogget som: ${innloggetMobil} / ${fornavn} ${etternavn}</p>
	<table>
        <tr>
            <th>Kjønn</th>
            <th align="left">Navn</th>
            <th align="left">Mobil</th>
        </tr>
        <c:forEach var="d" items="${deltagere}">
            <tr <c:if test="${d.mobil == innloggetMobil}">style="background-color: palegreen; color: black;"</c:if>>
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