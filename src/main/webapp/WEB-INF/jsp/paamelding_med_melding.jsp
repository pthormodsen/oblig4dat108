<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link href="/css/simple.css" rel="stylesheet" type="text/css" />
    <title>Påmelding</title>
    <style>
        .kjonn-valg label {
            display: inline;      /* legg etikettene på samme linje */
            margin-right: 10px;   /* litt luft mellom dem */
        }
    </style>
</head>

<body>
    <h2>Påmelding</h2>
    <p style="color:red;">Påmeldingsdetaljer er ugyldige</p>


    <form action="paamelding" method="post">
        <label for="fornavn">Fornavn</label>
        <input type="text" id="fornavn" name="fornavn" required><br>

        <label for="etternavn">Etternavn</label>
        <input type="text" id="etternavn" name="etternavn" required><br>

        <label for="mobil">Mobil (8 siffer)</label>
        <input type="text" id="mobil" name="mobil" pattern="\d{8}" required><br>

        <label for="passord">Passord</label>
        <input type="password" id="passord" name="passord" required><br>

        <label for="passord2">Passord repetert</label>
        <input type="password" id="passord2" name="passord2" required><br>

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
