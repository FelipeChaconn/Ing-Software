$(document).ready(function() {
    //Call Side Nav in Mobile button
    $('.sidenav').sidenav();
    //Slider js
    $('.slider').slider();
    //scrollspy
    $('.scrollspy').scrollSpy();
    //Modal 
    $('.modal').modal();
    //date picker function
    $('.datepicker').datepicker();
    //Dropdownfunction
    $('.dropdown-trigger').dropdown();
    //Auto complete
    $('input.autocomplete').autocomplete({
        data: {
            "San Jose": null,
            "Alajuela": null,
            "San Carlos": null,
            "Guanacaste": null,
            "Puntarenas": null,
            "Perez Zeledon": null,
            "Heredia": null,
            "Cartago": null
        },
    });

});

function logout() {
    //sessionStorage.removeItem(JSON.parse(sessionStorage.getItem('session_User')));
    sessionStorage.clear();
    window.location.replace("../../index.html");
}