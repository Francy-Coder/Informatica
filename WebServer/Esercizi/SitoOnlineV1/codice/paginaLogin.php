<html>
    <head></head>
    <body>
        <h1>paginaLogin</h1>
        <form action="paginaLogin.php" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Accedi">
        </form>
    </body>
</html>

<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $login = $_POST["login"];
    $cognome = $_POST["password"];

    $fileUtenti = "utenti.json";

    if (!file_exists($fileUtenti)) {
        die("Errore 404: fileUtenti non trovato.");
    }

    $utenti = json_decode(file_get_contents($fileUtenti), true);

    $trovato = false;
    foreach ($utenti as $utente) {
        echo($utente["login"]);
        echo($utente["password"]);

        if ($utente["login"] === $login && $password["password"] === $password){
            $trovato = true;
                 $_SESSION["utente"] = $utente;
        }
    }
    echo("<p style='color:red;'>Credenziali errate</p>");
}
?>