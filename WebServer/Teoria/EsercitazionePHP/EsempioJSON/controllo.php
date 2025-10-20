<?php
    $utenti = "utenti.json" 
?>

<html>
<head></head>
    <body>
        <h1>Controllo Credenziali</h1>
        <?php
        $k = $_GET["lg"];
        $v = $utenti[$k];
        if($v === $_GET["psw"])
          echo("<p style='color: green;'>Accesso Logatto</strong></p>");
        else 
            echo("<p style='color: red;'>Credenziali Errate</strong></p>");
        ?>
    </body>
</html>
    