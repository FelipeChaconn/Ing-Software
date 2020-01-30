//var arraylist of users
let userList = JSON.parse(localStorage.getItem('Users')) || [];
//constant for session storage user
const usr_session = sessionStorage.getItem('session_User');
const userFound = userList.find(user => user.userName === usr_session);

$(document).ready(function() {
    let usrname_const = document.getElementById('username_edit').value = userFound.userName;
    let tel_const = document.getElementById('teledit_number').value = userFound.tel;
    let speed_const = document.getElementById('speed_edit').value = userFound.speedA;
    let about_const = document.getElementById('about_edit').value = userFound.about;
});



function editUser() {
 let numId = userFound.numId;
 let userName = document.getElementById('username_edit').value;
 let tel = document.getElementById('teledit_number').value;
 let speedA = document.getElementById('speed_edit').value;
 let about = document.getElementById('about_edit').value;
 let password = userFound.password;
    // create the user object
    const user = {
        numId,
        userName,
        password,
        tel,
        speedA,
        about
    };
    debugger;
    //let userTest = JSON.parse(localStorage.getItem("Users"));
    let results = userList.filter(user => user.userName != usr_session);
    results.push(user);
    localStorage.setItem('Users', JSON.stringify(results));
      sessionStorage.setItem('session_User', usr_session);
     M.toast({html: 'Saved!', classes: 'rounded'});

    // Search user in arraylist

    debugger;

}