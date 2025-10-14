<?php
$utentiValidi = array("admin" => "admin123", "mario" => "rossi2024", "utente1" => "password1", "guest" => "guest");
$nomeUtente = $_GET["nomeUtente"];
$PSW = $_GET["PSW"];
?>

<!DOCTYPE html>
<html>
<head>
    <title>Controllo Login</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Risultato Login</h1>
    <?php
    if (array_key_exists($nomeUtente, $utentiValidi) && $utentiValidi[$nomeUtente] == $PSW) {
        echo "<p style='color: green;'><strong>Utente Loggato</strong></p>";
        echo "<p>Benvenuto, $nomeUtente!</p>";
    } else {
        echo "<p style='color: red;'><strong>Credenziali Errate</strong></p>";
        echo "<p>Login o password non corretti.</p>";
    }
    ?>
    <br>
    <a href="index.html">Torna al login</a>
</body>
</html>
