<?php
    $id_utente = $_POST["id_utente"];
    $nome = $_POST["nome"];
    $cognome = $_POST["cognome"];
    $email = $_POST["email"];
    $eta = $_POST["eta"];

    // 1. Connessione al database
    $conn = new mysqli("127.0.0.1", "root", "", "Biblioteca");

    // 2. Controllo se la connessione sia riuscita
    if ($conn->connect_error) {
        die("Connessione fallita: " . $conn->connect_error);
    }

    // 3. Scrivere la Query
    $sql = "INSERT INTO Utenti (id_utente, nome, cognome, email, eta)
            VALUES ('$id_utente', '$nome', '$cognome', '$email', '$eta')";

    // 4-5. Esecuzione della Query e verifica del risultato della query
    if ($conn->query($sql) === TRUE) {
        echo "<h2>Utente inserito correttamente!</h2>";
    } else {
        echo "Errore: " . $conn->error;
    }

    $conn->close();
?>
