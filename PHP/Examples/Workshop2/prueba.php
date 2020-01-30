<?php

 $ceu = array( "Italy"=>"Rome", "Luxembourg"=>"Luxembourg", "Belgium"=> "Brussels", "Denmark"=>"Copenhagen", "Finland"=>"Helsinki", "France" => "Paris", "Slovakia"=>"Bratislava", "Slovenia"=>"Ljubljana", "Germany" => "Berlin", "Greece" => "Athens", "Ireland"=>"Dublin", "Netherlands"=>"Amsterdam", "Portugal"=>"Lisbon", "Spain"=>"Madrid", "Sweden"=>"Stockholm", "United Kingdom"=>"London", "Cyprus"=>"Nicosia", "Lithuania"=>"Vilnius", "Czech Republic"=>"Prague", "Estonia"=>"Tallin", "Hungary"=>"Budapest", "Latvia"=>"Riga", "Malta"=>"Valetta", "Austria" => "Vienna", "Poland"=>"Warsaw") ;
$pais
 foreach ($ceu as $country => $capital){  
    echo "la capital de  ".$country." es ".$capital."\n";  
}  

$temperatura = [78, 60, 62, 68, 71, 68, 73, 85, 66, 64, 76, 63, 75, 76, 73, 68, 62, 73, 72, 65, 74, 62, 62, 65, 64, 68, 73, 75, 79, 73];
$media = array_sum($temperatura)/count($temperatura);
$promedio = number_format($media,0);
$highest = array();
$lowest  = array();
 foreach($temperatura as $valorTemperatura){
     if ($valorTemperatura>=$promedio){
       echo" es mayor que ","\n";
       array_push($highest,$valorTemperatura);
     }else{
        echo" es menor que ","\n" ; # $lowest =array_push($valor);
        array_push($lowest,$valorTemperatura);
     }
    
 }

 $arrayStringhigh = print_r($highest, true);
    $arrayString = print_r($lowest, true);

 echo "Highest temperature average is","\n",str_replace("\n", "", $arrayStringhigh),"\n";
 echo "Lowest temperature average is","\n",str_replace("\n", "", $arrayString),"\n";
 
echo "Average Temperature is : ".$promedio."\n";

?>