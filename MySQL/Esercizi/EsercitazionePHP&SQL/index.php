<html>
    <head></head>
    <body>
        <h1>Esercitazione PHP e SQL</h1>
        <p>Cerca persone tramite l'età</p>
        <form method="POST">
            Età: <input type="number" name="eta" required>
            <input type="submit" value="Invia">
        </form>
    </body>
</html>


<?php
    $eta = $_POST["eta"];
    
    // Connessione al database
    $conn = new mysqli("127.0.0.1", "root", "", "Biblioteca");
    
    if($conn->connect_error){
        die("Connessione fallita: " . $conn->connect_error); //Il "." è per concatenare
    }
    
    // Esegui la query solo se $eta è valorizzata e numerica
    $sql = "SELECT * FROM Utenti WHERE eta = $eta";
    $risultato = $conn->query($sql);
    
    if($risultato->num_rows > 0){
        while($riga = $risultato->fetch_assoc()){
            echo "ID_Utente: " . $riga["id_utente"] . "<br>";
            echo "Nome: " . $riga["nome"] . "<br>";
            echo "Cognome: " . $riga["cognome"] . "<br>";
            echo "Email: " . $riga["email"] . "<br>";
            echo "Età: " . $riga["eta"] . "<br><hr>";
        }
    } else {
        echo "Nessun utente trovato con età $eta.";
    }
    
    $conn->close();
?>
