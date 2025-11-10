<?php
    setcookie('utente', '', time() - 3600, '/');
    header('Location: index.php');
?>