<?php
    //definire la lista di contatti k =>
    $utenti = ["alice" => "alice123", "bob" => "bob2024", "carol" => "carol456", "dave" => "dave789", "elena" => "elena000", "frank" => "frank111",
                    "grace" => "grace222", "heidi" => "heidi333", "oscar" => "oscar444", "nina" => "nina555"]; // Altro modo per creare un array
?>

<html>
    <head></head>
        <body>
            <h1>Controllo Credenziali</h1>
            <?php
                $key = $_GET["loginUtente"]; // Prende il nome da index.html
                $value = $utenti[$key]; // Tramite il nome prende la chiave dall array utenti
                if($value === $_GET["password"]){
                    echo("<p style='color: green;'>Accesso Logatto</strong></p> <br>");
                    echo("Credenziali inserite: $");
                }else{ 
                    echo("<p style='color: red;'>Credenziali Errate</strong></p>");
                }
            ?>
        </body>
</html>
    
