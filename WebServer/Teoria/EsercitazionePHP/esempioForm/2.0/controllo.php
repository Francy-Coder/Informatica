<?php
    $nomeUtente = $_GET["nomeUtente"];
    $PSW = $_GET["PSW"];
?>

<head>
    <title>Benvenuto</title>
    </head>
    <body>
        <h1>Benvenuto</h1>
        <?php echo("<p>Nome Utente: $nomeUtente Password: $PSW</p>");?>
    </body>
</html>
