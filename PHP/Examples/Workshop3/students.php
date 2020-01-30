
<?php
include_once( 'functions.php');
$mysqli = OpenCon();


if ($mysqli === false) { 
    die("ERROR: Could not connect. " 
                          .$mysqli->connect_error); 
} 
echo "Digite cuantos registros quiere buscar: ";
$handle = fopen ("php://stdin","r");
$line = fgets($handle);
echo $line;
$sql = "SELECT  * FROM  workshop3Students  LIMIT $line"; 
if ($res = $mysqli->query($sql)) { 
    if ($res->num_rows > 0) { 
       
        echo "id "; 
        echo "name "; 
        echo "lastname "; 
        echo "cedula "; 
        echo "age "."\n";  
        while ($row = $res->fetch_array())  
        { 
         
            echo $row['id']," ",$row['name']," ",$row['lastname']," ",$row['cedula']," ",$row['age']."\n"; 
         
         
        } 
   
        $res->free(); 
    } 
    else { 
        echo "No matching records are found."; 
    } 
} 
else { 
    echo "ERROR: Could not able to execute $sql. " 
                                             .$mysqli->error; 
} 
$mysqli->close(); 
?> 