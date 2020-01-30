//Register constants
const idUser = document.getElementById('id_number');
const nameUserR = document.getElementById('username_reg');
const pswUserR = document.getElementById('password_reg');
const telUserR = document.getElementById('tel_number');
let sessionUser = {};

//Login constants
const userLogin = document.getElementById('username');
const passwordLogin = document.getElementById('passwordUser');

//var arraylist of users
let userList = JSON.parse(localStorage.getItem('Users')) || [];


//Create person object
function user(numId, userName, password, tel, speedA, about) {
    this.numId = numId;
    this.userName = userName;
    this.password = password;
    this.tel = tel;
    this.speedA = speedA;
    this.about = about;
}

//Adding users
function store() {
    userList.push(new user(idUser.value, nameUserR.value, pswUserR.value, telUserR.value, "", ""));
    localStorage.setItem("Users", JSON.stringify(userList));
    sessionUser = nameUserR.value;
    sessionStorage.setItem('session_User', sessionUser);
    console.log("# of users: " + userList.length);
    userList.forEach(function(user, index) {
        console.log("[" + index + "]: " + user.numId + ' ' + user.password);
    });
}

//verify user exists
function userCheck() {
    let name = [];
    let pass = [];
    userList.forEach(function(user, index) {
        name.push(user.userName);
        pass.push(user.password);
    });
    let user_exists = name.includes(userLogin.value);
    let pass_exists = pass.includes(passwordLogin.value);
    if (user_exists != false && pass_exists != false) {
        window.location = "public/html/dashboard.html";
        sessionUser = userLogin.value;
        sessionStorage.setItem('session_User', sessionUser);
    } else {
        alert("User or Password incorrect");
        window.stop();

    }
}

//Check passwords are equals
function checkPassword() {
    if ($('#password_check').val() !== $('#password_reg').val()) {
        $('#password_check')[0].setCustomValidity('Passwords must match.');
    } else {
        $('#password_check')[0].setCustomValidity('');
    }
}