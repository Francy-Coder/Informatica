<html>
    <head></head>
    <body>
        <h1>Esercitazione Sicurezza</h1>
        <p>Login utente tramite email e password</p>
        <form method="POST">
            Email: <input type="email" name="email" required><br>
            Password: <input type="string" name="psw" required><br>
            <input type="submit" value="Invia">
        </form>
    </body>
</html>

<?php
if (isset($_POST["email"], $_POST["psw"])) {
    $email = $_POST["email"];
    $psw = $_POST["psw"];

    $conn = new mysqli("127.0.0.1", "root", "", "Biblioteca");

    if($conn->connect_error){
        die("Connesione fallita: " . $conn->connect_error);
    }

    //Previene SQL Injection
    $email = $conn->real_escape_string($_POST["email"]);
    $psw = $conn->real_escape_string($_POST["psw"]);

    $sql = "SELECT * FROM Utenti WHERE email = '$email' AND psw = '$psw'";
    $risultato = $conn->query($sql);
    
    if($risultato->num_rows > 0){
        while($riga = $risultato->fetch_assoc()){echo "<p>ID_Utente: " . $riga['id_utente'] . " | Nome: " . $riga['nome'] . " | Cognome: " . $riga['cognome'] . " | Email: " . $riga['email'] . " | Età: " . $riga['eta'] . " | Password: " . $riga['psw'] . "</p>";
            
        }
    }else{
        echo "Nessun utente trovato";
    }

    $conn->close();
}else{
    echo "Compila tutti i campi del form.";
}
?>
