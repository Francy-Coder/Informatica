<html>
<head>
    <body>
        <form action="index.php" method="POST">
            Inserisci il tuo Nome: <input type="text" name="nome"><br>
            Inserisci il tuo Cognome: <input type="text" name="cognome"><br>
            Inserisci il Font: <input type="text" name="font"><br>
            Inserisci il Colore del Testo: <input type="text" name="colore_testo"><br>
            Inserisci il Colore della Pagina: <input type="text" name="colore_pagina"><br>
        
            <input type="submit" value="Invia">
        </form>
    </body>
</head>
</html>

<?php
    $color = $_POST["colore_testo"];
    $nome = $_POST["nome"];

    $stringa = "<h1 style='colore: $color;'>Ciao $nome</h1>";
    echo($stringa);

    /*
    setcookie("nome", $_POST['nome'], $durata);
    setcookie("cognome", $_POST['cognome'], $durata);
    */

?>