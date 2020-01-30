$( document ).ready(function() {
   //constant for session storage user
const let_user = sessionStorage.getItem('session_User');
    document.getElementById("user_name").innerHTML = "<a>" + "<i class='material-icons'>account_circle</i>" + let_user + "</a>";
});
