<html>
    <head></head>
    <body>
        <h1>Esercitazione Sicurezza</h1>
        <p>Login utente tramite email e password</p>
        <form method="POST">
            Email: <input type="email" name="email" required><br>
            Password: <input type="password" name="psw" required><br>
            <input type="submit" value="Invia">
        </form>
    </body>
</html>

<?php
    $email = $_POST["email"];
    $psw = $_POST["psw"];

    $conn = new mysqli("127.0.0.1", "root", "", "Biblioteca");

    if($conn->connect_error){
        die("Connesione fallita: " . $conn->connect_error);
    }

    $sql = "SELECT * FROM Utenti WHERE email = '$email' AND psw = '$psw'";
    $risultato = $conn->query($sql);

    if($risultato->num_rows > 0){
        while($riga = $risultato->fetch_assoc()){
            echo "ID_Utente: " . $riga["id_utente"] . "<br>";
            echo "Nome: " . $riga["nome"] . "<br>";
            echo "Cognome: " . $riga["cognome"] . "<br>";
            echo "Email: " . $riga["email"] . "<br>";
            echo "Età: " . $riga["eta"] . "<br>";
            echo "Password: " . $riga["psw"] . "<br>";
        }
    }else{
        echo "Nessun utente trovato";
    }

    $conn->close();
?>
