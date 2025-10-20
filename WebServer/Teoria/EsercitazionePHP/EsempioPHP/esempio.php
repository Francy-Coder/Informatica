<?php $nome = "paolo";?>
<html>
    <head></head>
    <body>
        <h1>PRIMA WEBAPP</h1> 
        <p>Ciao <?php echo($nome);?></p>
        <?php echo("<p>tipo: ".gettype($nome)."</p><p>".var_dump($nome)."</p>");?>
    </body>
</html>
