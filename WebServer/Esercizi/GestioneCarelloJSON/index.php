<html>
    <head></head>
    <body>
        <h1>Login Gestione Carrello</h1>
        <form action="index.php" method="POST">
            Nome: <input type="text" name="nome"><br>
            Cognome: <input type="text" name="cognome"><br>
            ID: <input type="number" name="id"><br>
            <input type="submit" value="Accedi">
        </form>
    </body>
</html>

<?php
$nome = $_POST["nome"];
$cognome = $_POST["cognome"];
$ID = $_POST["id"];

$nomeFile = "utente.json";

if (!file_exists($nomeFile)) {
    die("Errore di Sistema");
}

$json = file_get_contents($nomeFile);
$arrayUtenti = json_decode($json, true);

$utenteTrovato = false;

foreach ($arrayUtenti as $utente) {
    if ($utente['nome'] === $nome && $utente['cognome'] === $cognome && $utente['id'] == $ID) {
        $utenteTrovato = true;
        break;
    }
}

if ($utenteTrovato) {
    echo "<p style='color: green;'>Credenziali corrette</p>";

    include("mostraCarello.php");
    include("oggetti.php");
    mostraCarello();

} else {
    echo "<p style='color: red;'>Credenziali errate</p>";
}
?>