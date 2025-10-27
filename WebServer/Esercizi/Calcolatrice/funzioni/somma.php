<?php
    function somma($parmetri){
        $somma=0;
        foreach($parmetri as $n){
            $somma = $somma + $n;
        }
        return $somma;
    }
?>