<?php
// output headers so that the file is downloaded rather than displayed
header('Content-type: text/csv');
header('Content-Disposition: attachment; filename="demo.csv"');
 
// do not cache the file
header('Pragma: no-cache');
header('Expires: 0');
 $host = $argv[1];
 $username= $argv[2];
 $password=$argv[3];
 $bd=$argv[4];
 $table=$argv[5];
 $output=$argv[6];
// create a file pointer connected to the output stream
$file = fopen('php://output', 'w');
 
// send the column headers
fputcsv($file, array('ID', 'Nombre', 'Apellidos', 'Cedula', 'Edad'));
 
/// Open the connection
$link = mysqli_connect($host, $username,$password, $bd);
 
//query the database
$query = "SELECT * FROM  '$table'";
 
if ($rows = mysqli_query($link, $query))
{
// loop over the rows, outputting them
while ($row = mysqli_fetch_assoc($rows))
{
fputcsv($file, $row);
}

}
// close the connection
mysqli_close($link);
?>