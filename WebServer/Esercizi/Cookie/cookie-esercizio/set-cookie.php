<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = trim($_POST['nome'] ?? '');

    if (!empty($nome)) {
        setcookie('utente', $nome, time() + 3600, '/');
        header('Location: index.php');
        exit;
    }else{
        echo("Nome non valido. <a href='index.php'>Torna indietro</a>");
    }
}else{
    header('Location: index.php');
    exit;
}
?>
