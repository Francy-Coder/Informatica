<?php
    //definire la lista di contatti k =>
    $utenti = [
        "alice" => "alice123",
        "bob" => "bob2024",
        "carol" => "carol456",
        "dave" => "dave789"
        "elena" => "elena000"
        "frank" => "frank111"
        "grace" => "grace222"
        "heidi" => "heidi333"
        "oscar" => "oscar444"
        "nina" => "nina555"
    ];
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
    
