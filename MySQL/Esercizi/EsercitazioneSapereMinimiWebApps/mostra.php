<?php
session_start();

if(isset($_SESSION['id_utente'])) {

    $id_utente = $_SESSION['id_utente'];
    $conn = new mysqli("127.0.0.1", "root", "", "Biblioteca");

    if($conn->connect_error){
        die("Connessione fallita: " . $conn->connect_error);
    }

    // Prepared statement
    $stmt = $conn->prepare("SELECT * FROM Utenti WHERE id_utente = ?");
    $stmt->bind_param("i", $id_utente);
    $stmt->execute();
    $risultato = $stmt->get_result();

    if($riga = $risultato->fetch_assoc()){
        echo "<h2>Informazioni utente</h2>";
        echo "<p><strong>ID Utente:</strong> {$riga['id_utente']}<br>
              <strong>Nome:</strong> {$riga['nome']}<br>
              <strong>Cognome:</strong> {$riga['cognome']}<br>
              <strong>Email:</strong> {$riga['email']}<br>
              <strong>Età:</strong> {$riga['eta']}</p>";
    } else {
        echo "Utente non trovato.";
    }

    $stmt->close();
    $conn->close();

} else {
    echo "Accesso negato. Effettua il login prima.";
}
?>
