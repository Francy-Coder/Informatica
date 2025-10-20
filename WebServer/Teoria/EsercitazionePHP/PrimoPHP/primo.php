<?php
// Il codice php
	$nome = "Francy"; // Variabile che contiene il nome
	$l = "<h1 style='color: red;'>Hello $nome</h1>";
	echo($l);

    // " = In PHP, le virgolette doppie permettono l'interpolazione di variabili e riconoscono le sequenze di escape.
    // ' = Le virgolette singole (') trattano il contenuto come testo letterale senza interpretazioni speciali.

    // Stampare a video il contenuto della lista 
        // utilizzando un ciclo for-each --> chiave:valore
    $lista = array(1,2,3,4,5,6,7,8,9,0);
 
    // for(<tipo> nome : lista <-- Java
    echo("<h1>Contenuto lista</h1>");
    foreach($lista as $k=>$v){
        echo("<p>$k: $v</p>"); // <p></p> per andare a capo
    }
?>
