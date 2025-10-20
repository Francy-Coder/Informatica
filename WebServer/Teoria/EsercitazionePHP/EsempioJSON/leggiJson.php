<?php
    /**
     * Leggere un file json
     *      - path: utenti.json
     *      - file_exist($path) --> TURE se esiste il file, FALSE altrimenti
     * Stmpare il contenuto a video
     *      - leggere il contenuto del file
     */

    $path = "utenti.json"
    if(!file_exist($path))
        die("Errore il file non esiste"); //Interroge l'esecuzione dello script
    else{
        //leggere il contenuto
        $json = file_get_contents("utenti.json");
        //var_dump($contenuto); --> Stampa a video il contenuto della variabile e il tipo
        $dati = json_decode($json, true);
        //var_dump($contenuto);
        foreach($dati as $valore){
            echo("<p>");
            foreach($valore as $k=>$v){
                echo("$k: $v</br>");
            }
            echo("</p>")
        }
    }
?>
