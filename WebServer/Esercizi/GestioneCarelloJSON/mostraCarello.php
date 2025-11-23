<?php
session_start();

if (!isset($_SESSION["utente"])) {
    header("Location: index.php");
    exit;
}

$listaOggetti = json_decode(file_get_contents("oggetti.json"), true);

$mappa = [];
foreach ($listaOggetti as $o) {
    $mappa[$o["id"]] = $o["nome"];
}
if (isset($_GET["svuota"])) {
    $_SESSION["carrello"] = [];
}
?>

<html>
    <head><title>Carrello</title></head>
    <body>
    <h1>Carrello di <?= $_SESSION["utente"]["nome"]; ?> <?= $_SESSION["utente"]["cognome"]; ?></h1>

    <a href="oggetti.php">Torna alla lista oggetti</a>
    <hr>

    <?php if (empty($_SESSION["carrello"])): ?>

    <p>Il carrello è vuoto.</p>

    <?php else: ?>

    <ul>
    <?php foreach ($_SESSION["carrello"] as $id => $quantita): ?>
        <li><?= $mappa[$id]; ?> — Quantità: <?= $quantita; ?></li>
    <?php endforeach; ?>
    </ul>

    <a href="mostraCarrello.php?svuota=1">Svuota Carrello</a>

    <?php endif; ?>
    </body>
</html>
