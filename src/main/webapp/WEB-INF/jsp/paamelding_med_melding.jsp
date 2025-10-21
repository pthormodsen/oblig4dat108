<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="/css/simple.css" rel="stylesheet" type="text/css" />
    <title>Påmelding</title>
    <style>
        .kjonn-valg label {
            display: inline;
            margin-right: 10px;
        }

        input:valid {
            background-color: palegreen;
        }

        input:invalid {
            background-color: lightpink;
        }

        .passord-mismatch {
            background-color: lightpink !important;
        }

        input[type="text"],
        input[type="password"] {
            color: #000;
        }
    </style>
</head>

<body>
    <h2>Påmelding</h2>
    <c:if test="${not empty melding}">
        <p style="color:red;"><b>${melding}</b></p>
    </c:if>

    <form action="paamelding" method="post">
        <label for="fornavn">Fornavn</label>
        <input type="text" id="fornavn" name="fornavn" required
               pattern="[A-ZÆØÅ][a-zæøå\- ]{1,19}"
               title="Stor første bokstav, 2-20 tegn"> <br>

        <label for="etternavn">Etternavn</label>
        <input type="text" id="etternavn" name="etternavn" required
               pattern="[A-ZÆØÅ][a-zæøå\- ]{1,19}"
               title="Stor første bokstav, 2-20 tegn"> <br>

        <label for="mobil">Mobil (8 siffer)</label>
        <input type="text" id="mobil" name="mobil" required
               pattern="\d{8}"
               title="Akkurat 8 siffer"><br>

        <label for="passord">Passord</label>
        <input type="password" id="passord" name="passord" required
               minlength="4"
               title="Må være mer en 4 tegn"><br>

        <label for="passord2">Passord repetert</label>
        <input type="password" id="passord2" name="passord2" required
               minlength="4"
               title="Må være mer en 4 tegn"><br>

        <script>
            function sjekkPassordMatch() {
                var passord = document.getElementById('passord');
                var passord2 = document.getElementById('passord2');
                if (passord2.value !== passord.value) {
                    passord2.setCustomValidity('Passordene må være like');
                    passord2.classList.add('passord-mismatch');
                } else {
                    passord2.setCustomValidity('');
                    passord2.classList.remove('passord-mismatch');
                }
            }
            document.getElementById('passord').oninput = sjekkPassordMatch;
            document.getElementById('passord2').oninput = sjekkPassordMatch;
        </script>

        <label>Kjønn</label>
        <div class="kjonn-valg">
            <input type="radio" id="mann" name="kjonn" value="mann" required>
            <label for="mann">mann</label>

            <input type="radio" id="kvinne" name="kjonn" value="kvinne">
            <label for="kvinne">kvinne</label>
        </div>
        <br>

        <button type="submit">Meld meg på</button>
    </form>
</body>
</html>
