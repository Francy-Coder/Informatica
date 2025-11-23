<?php
session_start();
session_set_cookie_params(3600);

if (isset($_SESSION["utente"])) {
    header("Location: oggetti.php");
    exit;
}
?>

<html>
<head><title>Login</title></head>
<body>
<h1>Login Gestione Carrello</h1>

<form action="index.php" method="POST">
    Nome: <input type="text" name="nome" required><br>
    Cognome: <input type="text" name="cognome" required><br>
    ID: <input type="number" name="id" required><br>
    <input type="submit" value="Accedi">
</form>
</body>
</html>

<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $nome = $_POST["nome"];
    $cognome = $_POST["cognome"];
    $id = $_POST["id"];

    $fileUtenti = "utente.json";

    if (!file_exists($fileUtenti)) {
        die("Errore di sistema: utenti non trovati.");
    }

    $utenti = json_decode(file_get_contents($fileUtenti), true);

    $trovato = false;
    foreach ($utenti as $utente) {
        if ($utente["nome"] === $nome &&
            $utente["cognome"] === $cognome &&
            $utente["id"] == $id) {
            
            $trovato = true;
            $_SESSION["utente"] = $utente;

            if (!isset($_SESSION["carrello"])) {
                $_SESSION["carrello"] = [];
            }

            header("Location: oggetti.php");
            exit;
        }
    }

    echo "<p style='color:red;'>Credenziali errate</p>";
}
?>
