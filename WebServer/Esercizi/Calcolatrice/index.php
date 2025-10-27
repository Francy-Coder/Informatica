<?php
$n1 = $_GET["n1"];
$n2 = $_GET["n2"];
$do = $_GET["do"];

if ($do == "+") {
  $result = ($num1 + $num2);
} elseif ($do == "-") {
  $result = ($num1 - $num2);
} elseif ($do == "x") {
  $result = ($num1 * $num2);
} else {
  $result = ($num1 / $num2);
}

die('{"status":200,"result":' .$result. '}');
?>