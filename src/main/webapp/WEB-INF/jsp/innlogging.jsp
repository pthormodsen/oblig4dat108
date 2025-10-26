<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="/css/simple.css" rel="stylesheet" type="text/css" />
    <title>Innlogging</title>
    <style>

    </style>
    <script>
        function togglePassword() {
            const passwordField = document.getElementById("passord");
            passwordField.type = passwordField.type === "password" ? "text" : "password";
        }
    </script>
</head>

<body>
<h2>Innlogging</h2>
<c:if test="${not empty melding}">
    <p style="color:red;"><b>${melding}</b></p>
</c:if>
<c:if test="${not empty param.melding}">
    <p style="color:red;"><b>${param.melding}</b></p>
</c:if>

<form action="innlogging" method="post">
    <label for="mobil">Mobilnummer</label>
    <input type="text" id="mobil" name="mobil" required pattern="\d{8}" title="Akkurat 8 siffer" /> <br>

    <label for="passord">Passord</label>
    <input type="password" id="passord" name="passord" required />
    <label for="showPassord">Vis passord</label>
    <input type="checkbox" id="showPassord" onclick="togglePassword()"> <br>

    <button type="submit">Logg inn</button><br>

    <a href="paamelding">Gå til påmelding</a>
</form>
</body>
</html>
