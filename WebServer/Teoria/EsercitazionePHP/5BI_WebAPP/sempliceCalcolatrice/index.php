<?php
/*
    include 'conf/config.php'; //Include il file specificato
                                    //Path e il nome del file da includere

    //include_once 'conf/config.php'; //Include un file solo una volta

    if(isset($name)) /*isset = Verifica se una variabile è stata definita e non è null.
                       unset = Cancella una variabile (la rimuove dalla memoria). 
                       empty = Verifica se la variabile è vuota o falsa nel senso ampio./
        echo "<h1>$name</h1>";
    else
        echo  "<h1>Impossibile acceder al file config.php</h1>"
*/
    //require_once 'front_end/uno.php';

    include 'funzioni/calcolatrice.php';
    $dati = array(1,2,3,4,5,6,7,8,9);
    $risultato = somma($dati)
    echo "$risultato";
    //echo "<h3>Somma di N numeri</h3><p>somma:".somma($dati)."</p>";
?>