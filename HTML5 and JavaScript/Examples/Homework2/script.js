function mostrarFecha() {
	//Constantes del registro 
var dt = new Date();
  console.log("Today is : "+dt.toString());
   alert("Today is : "+dt.toString());
}

window.onload =function mostrarURL(){
	var url= document.URL;

	console.log(url.toString());
}