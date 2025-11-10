<html>
<head></head>
<body>
    <h1>Calcolatrice</h1>
    <form action="index.php" method="POST">
        Primo Valore: <input type="number" name="primo_valore"><br><br>
        Secondo Valore: <input type="number" name="secondo_valore"><br><br>
        
        <input type="submit" name="operazione" value="Somma">
        <input type="submit" name="operazione" value="Sottrazione">
        <input type="submit" name="operazione" value="Moltiplicazione">
        <input type="submit" name="operazione" value="Divisione">
    </form>
</body>
</html>

<?php
    $a = $_POST["primo_valore"];
    $b = $_POST["secondo_valore"];
    $operazione = $_POST["operazione"];
    $risultato = null;

    include("funzioni/somma.php");
    include("funzioni/sottrazione.php");
    include("funzioni/moltiplicazione.php");
    include("funzioni/divisione.php");

    if ($operazione == "Somma"){
        $risultato = somma($a, $b);
    } elseif ($operazione == "Sottrazione"){
        $risultato = sottrazione($a, $b);
    } elseif ($operazione == "Moltiplicazione"){
        $risultato = moltiplicazione($a, $b);
    } elseif ($operazione == "Divisione"){
        $risultato = divisione($a, $b);
    }

    echo("Risultato: $risultato");
?>

