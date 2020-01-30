<?php
$servername = "localhost";
$username = "felipe";
$password = "admin";
$dbname = "watchband_bd";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
$sql = "SELECT stockP FROM product WHERE stockP<=3";
$result = mysqli_query($conn, $sql);
// Your preset inventory...
$threshold = 5; 
$recipient = "luis.felipe16981460@gmail.com";
if (mysqli_num_rows($result) > 0) {
    while($row = mysqli_fetch_assoc($result)) {
        $inventory = $row['stockP'];
    }
    echo"Starting to send...";
    $msg = "Inventory for product has fallen beneath threshold. $inventory remaining.";
    mail($recipient, "Inventory check below threshold", $msg);
    
}
?>