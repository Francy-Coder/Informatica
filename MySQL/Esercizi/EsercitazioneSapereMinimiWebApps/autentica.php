<?php
session_start();

if (isset($_POST["email"], $_POST["psw"])) {

    $email = $_POST["email"];
    $psw = $_POST["psw"];

    $conn = new mysqli("127.0.0.1", "root", "", "Biblioteca");

    if($conn->connect_error){
        die("Connessione fallita: " . $conn->connect_error);
    }

    // Prepared statement con BIND
    $stmt = $conn->prepare("SELECT * FROM Utenti WHERE email = ? AND psw = ?");
    $stmt->bind_param("ss", $email, $psw);
    $stmt->execute();
    $risultato = $stmt->get_result();

    if($riga = $risultato->fetch_assoc()){
        // Salvo l'ID utente in sessione
        $_SESSION['id_utente'] = $riga['id_utente'];

        echo "<p>Login riuscito</p>";
        echo "<p><strong>Nome:</strong> {$riga['nome']}<br>
              <strong>Cognome:</strong> {$riga['cognome']}<br>
              <strong>Email:</strong> {$riga['email']}<br>
              <strong>Età:</strong> {$riga['eta']}</p>";
        
        echo '<a href="mostra.php">Vai alla pagina Mostra</a>';
    } else {
        echo "Email o password errate!";
    }

    $stmt->close();
    $conn->close();
} else {
    echo "Compila tutti i campi del form.";
}
?>
