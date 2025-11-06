<?php
if(isset($_COOKIE['utente'])){
    $nome = htmlspecialchars($_COOKIE['utente']);
    echo("<h2>Benvenuto, $nome</h2>");
    echo('<a href="delete-cookie.php">Cancella cookie</a>');
}else{
    echo('
    <form action="set-cookie.php" method="post">
        <label for="nome">Inserisci il tuo nome:</label><br>
        <input type="text" id="nome" name="nome" required>
        <button type="submit">Invia</button>
    </form>
    ');
}
?>
