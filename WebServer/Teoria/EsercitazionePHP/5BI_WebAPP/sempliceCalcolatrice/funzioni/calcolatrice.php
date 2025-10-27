<?php
    function somma($parmetri){
        $somma=0;
        foreach($parmetri as $n){
            $somma = $somma + $n;
        }
        return $somma;
    }

    function moltiplicazione($parmetri){
        $somma=1;
        foreach($parmetri as $n){
            $somma = $somma * $n;
        }
        return $somma;
    }
?>