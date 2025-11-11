<?php
$pizza = "piece1 piece2 piece3 piece4 piece5";
$pezzi = explode(" ", $pizza);  // Mi restituisce tutti i singoli pezzi della stringa
                                    //" " stabilisce dove viene separato
                                    //$pizza è la stringa che vogliamo separare
                                // explode();
                                    // Ci permettera di salvare con la stessa key i cookie
                                    // Simile allo split();
                                        
foreach($pezzi as $pezzo){
    echo("$pezzo <br>");
}
?>

