#!/usr/bin/php -q
<?php
include 'src/model/cronjob.php';
include 'src/model/sql_cronjob.php';
class Cronjob extends sql_cronjob
{
 // Your preset inventory...


 public function cronjobWork(){
     $threshold = 4;
   $recipient = "luis.felipe16981460@gmail.com";

   $query = $this->connect()->prepare("SELECT stockP FROM product");
    $query->execute();
    if ($query) {
      $row = mysql_fetch_assoc($query);
      $inventory = $row['stockP'];
      if ($inventory <= $threshold) {
        $msg = "Inventory for product has fallen beneath threshold. $inventory remaining.";
        mail($recipient, "Inventory check below threshold", $msg);
      }
    }
    else {
      $msg = "An error occurred while checking inventory: " . mysql_error();
      mail($recipient, "Inventory check error", $msg);
    }
 }
}

?>