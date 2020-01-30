//Constantes del registro 
//const apellidoRegistro = document.getElementById('apellidoForm').value;
//const telefonoRegitro = document.getElementById('telForm').value;
//variable arraylist de usuarios
var listaUsuarios = JSON.parse(localStorage.getItem('Usuarios')) || [];

//Crea el objeto persona
function Persona(nombre,apellido,telefono) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.telefono = telefono;
}


function guardarUsuario() {
	//Constantes del registro 
var nombreRegistro = document.getElementById('nombreForm');
var apellidoRegistro = document.getElementById('apellidoForm');
var telefonoRegitro = document.getElementById('telForm');
  listaUsuarios.push(new Persona(nombreRegistro.value,apellidoRegistro.value,telefonoRegitro.value));

  localStorage.setItem("Usuarios",JSON.stringify(listaUsuarios));

  
}
function mostrarDatosConsola(){
	console.log("# de usuarios: " + listaUsuarios.length);
  listaUsuarios.forEach(function(Persona, index) {
    console.log("[" + index + "]: " + Persona.nombre +' '+ Persona.apellido);
  });
}