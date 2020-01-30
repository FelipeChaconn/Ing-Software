<?php
include_once 'src/controller/user_controller.php';
include_once 'src/controller/user_session.php';
//Start Session and create new User
$userSession = new UserSession();
$user        = new User();
$userAdmin   = 1;

//Check if User is in Session
if (isset($_SESSION['user'])) {
  //echo "hay sesion";
  $user->setUser($userSession->getCurrentUser());
  if ($user->getUserRole() == $userAdmin) {
    include_once 'src/controller/admin_controller.php';
  } else {
    include_once 'src/controller/user_view_controller.php';
  }
} else if (isset($_POST['idLog']) && isset($_POST['verifyPassword'])) {

  $userForm = $_POST['idLog'];
  $passForm = $_POST['verifyPassword'];
  $user     = new User();
  if ($user->userExists($userForm, $passForm)) {

    //echo "Existe el usuario";
    $userSession->setCurrentUser($userForm);
    $user->setUser($userForm);
    if ($user->getUserRole() == $userAdmin) {
      include_once 'src/controller/admin_controller.php';
      //header('Location: ?status=success');
    } else {
      include_once 'src/controller/user_view_controller.php';
      //header('Location: ?status=success');
    }
  } else {

    $errorLogin = "Name or password incorrect!";
    header('Location: ?status=error');
    include_once 'src/views/login.php';
  }
} else if (isset($_POST['idRegister'])) {
  $userIdRegister       = $_POST['idRegister'];
  $userNameRegister     = $_POST['nameUsrRegister'];
  $userLastNameRegister = $_POST['lstnameUsrRegister'];
  $userPassRegister     = $_POST['pswUsrRegister'];
  $userTelRegister      = $_POST['telUsrRegister'];
  $userAddrRegister     = $_POST['addrUsrRegister'];
  $userEmailRegister    = $_POST['emailUsrRegister'];
  if ($user->userExistsByID($userIdRegister) == false) {
    $user->addUser($userIdRegister, $userNameRegister, $userLastNameRegister, $userPassRegister, $userTelRegister, $userAddrRegister, $userEmailRegister, 2);
    $userSession->setCurrentUser($userIdRegister);
    $user->setUser($userIdRegister);
    //echo ("added");
    if ($user->getUserRole() == $userAdmin) {
      include_once 'src/controller/admin_controller.php';
    } else {
      include_once 'src/controller/user_view_controller.php';
    }
  } else {
    // header('Location: src/views/login.php/?status=error');
    $errorRegister = "You actually have account!";
    include_once 'src/views/login.php';
  }
} else {
  //echo "login";

  include_once 'src/views/login.php';
}
