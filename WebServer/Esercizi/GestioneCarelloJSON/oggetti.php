<?php
session_start();

if (!isset($_SESSION["utente"])) {
    header("Location: index.php");
    exit;
}

$listaOggetti = json_decode(file_get_contents("oggetti.json"), true);

if (isset($_GET["add"])) {
    $id = $_GET["add"];

    if (!isset($_SESSION["carrello"][$id])) {
        $_SESSION["carrello"][$id] = 1;
    } else {
        $_SESSION["carrello"][$id]++;
    }
}
?>

<html>
<head><title>Lista Oggetti</title></head>
<body>

<h1>Benvenuto <?= $_SESSION["utente"]["nome"]; ?></h1>

<a href="mostraCarrello.php">Mostra Carrello</a>
<hr>

<h2>Lista Oggetti</h2>

<ul>
<?php foreach ($listaOggetti as $obj): ?>
    <li>
        <?= $obj["nome"]; ?>  
        <a href="oggetti.php?add=<?= $obj["id"]; ?>">[Aggiungi al carrello]</a>
    </li>
<?php endforeach; ?>
</ul>

</body>
</html>
