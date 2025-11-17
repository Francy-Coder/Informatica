<html>
    <head></head>
    <body>
        <h1>Login Gestione Carrello</h1>
        <form action="index.php" method="POST"><br>
            Username: <input type="text" name="username"><br>
            ID: <input type="text" name="id"><br>
            <input type="submit" value="Accedi">
        </form>
    </body>
</html>

<?php
/* Dopo il login l'utente può decidere se vedere il carrello oppure la lista di oggetti per aggiungere al carrello.
Salvare i dati del carello in una sessione della durata di 1 ora.
*/

$username = $_POST["username"];
$ID = $_POST["id"];

if(){
    //Confronto fra i dati inseriti e quelli presenti nel JSON

    //Funzione: mostraCarello e Oggetti <-- ? 
        /*
        index -   serve per il login
        oggetti -   mostra una lista di oggetti differenti che l'utente può inserire nel carello.
        mostra carello -  mostra i dati dell'utente e l'elenco degli oggetti.
        utente.json  -   contiene i dati di registrazione: id, nome, cognome.
        oggetti.json - contine i dati degli oggetti : id, nome.
        */
    
}


?>