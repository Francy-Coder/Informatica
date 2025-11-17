<html>
<head>
    <body>
        <form action="index.php" method="POST">
            Inserisci il tuo Nome: <input type="text" name="nome"><br>
            Inserisci il tuo Cognome: <input type="text" name="cognome"><br>
            Inserisci il Font: <input type="text" name="font"><br>
            Inserisci il Colore del Testo: <input type="color" name="colore_testo"><br>
            Inserisci il Colore della Pagina: <input type="color" name="colore_pagina"><br>
            <input type="submit" value="Invia">
        </form>
    </body>
</head>
</html>

<?php
    $nome = $_POST["nome"];
    $cognome = $_POST["cognome"];
    $font = $_POST["font"];
    $colore_testo = $_POST["colore_testo"];
    $colore_pagina = $_POST["colore_pagina"];
    
    echo("Nome: $nome <br>");
    echo("Cognome: $cognome <br>");
    echo("Font: $font <br>");
    echo("Colore testo: $colore_testo <br>");
    echo("Colore pagina: $colore_pagina <br>");

    /*
    setcookie("nome", $_POST['nome'], $durata);
    setcookie("cognome", $_POST['cognome'], $durata);
    */
?>
