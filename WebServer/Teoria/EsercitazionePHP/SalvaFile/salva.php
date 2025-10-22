<?php
/***
 * Informazione aggiungerla all'array con dai
 * $dati -> array che contiene lo stato degli oggetti
 *       -> aggiungo a $dati[< informazioni oggetto>]
 * json_encode: riceve un array associativo e lo trasforma in una stringa cod. JSON
 * file_put_contents($nomeFile, contenuto) --> sovrascrive tutto
 */

/**
 * TO DO:
 * - Leggere il file json_get_contents
 * - Trasformarlo in array ass. json_decode
 * 
 *          ----------------
 *  - Aggiunge all'array asso. il nuovo oggetto
 *  - Trasforma in codifica json --> json_encode
 *  - Salvare su file --> file_put_contents
 */

$nomeFile = "file.json";
if(file_exists($nomeFile)){
    die("cxvxcvxz");
}else{
    $json = file_get_contents($nomeFile);
    // echo("Contenuto: $json");
    $array = json_decode($nomeFile, true);

    //Rappresentazione oggetto
    $nuovoUtente = [
        "login" => "PAOLO",
        "password" => "qwerty"
    ];

    //Aggiungere
    $array[] = $nuovoUtente;

    foreach($array as $utente){
    echo("<p>");
        foreach($utente as $k=$v){
            echo("$k: $v </br>");
        }
    echo("</p>");
    }

    // Codifica in stringa JSON
    $json = json_decode($array, JSON_PRETTY_PRINT);
    echo($json);
    // Salva su files
    file_put_contents($nomeFile, $json);
}
?>
