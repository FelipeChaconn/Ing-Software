<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,
      shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>WatchBands CR</title>
    
    <link href="public/css/loader.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora&display=swap"
      rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="public/css/login.css" rel="stylesheet">

    <!-- Favicon
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link rel="icon" type="image/png" href="public/assets/watchlogo.png">
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <?php echo " <a class='navbar-brand'  href='src/views/principal_view.php'>Watch Bands CR</a>";?>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        </ul>
        <form   action="" method="POST" class="form-inline my-2 my-lg-0">
        <?php
            if(isset($errorLogin)){ 
                echo "<div class='alert alert-danger  my-2 my-lg-0' role='alert'>";
                echo $errorLogin;
                echo"</div>";
             
            }
        ?>
          <div class="form-label-group">
            <input type="" id="idLog" name="idLog" class="form-control"
              placeholder="Id Number" required autofocus>
            <input type="password" name= "verifyPassword"id="verifyPassword" class="form-control"
              placeholder="Password" required>
          </div>
          <button class="btn btn-primary btn-sm" type="submit">sign in</button>
        </form>
      </div>
    </nav>
    <div class="container">
      <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
          <div class="card card-signin my-5">
            <div class="card-body">
              <h5 class="card-title text-center">Register Now!</h5>
              <form action="" method="POST" class="form-signin">
              <?php
            if(isset($errorRegister)){ 
                echo "<div class='alert alert-danger  my-2 my-lg-0' role='alert'>";
                echo $errorRegister;
                echo"</div>";
             
            }
        ?>
                <div class="form-label-group">
                  <input id="inputId" class="form-control" name="idRegister" placeholder="Number id" required autofocus>
                  <label for="inputId">Id Number</label>
                </div>

                <div class="form-label-group">
                  <input type="text" id="inputName" class="form-control" name="nameUsrRegister" placeholder="Name"
                    required>
                  <label for="inputName">Name</label>
                </div>
                <div class="form-label-group">
                  <input  type="text" id="inputLastName" class="form-control"
                  name="lstnameUsrRegister" placeholder="Last Name" required>
                  <label for="inputLastName">Last Name</label>
                </div>

                <div class="form-label-group">
                  <input type="password" id="inputPassword" class="form-control"
                  name="pswUsrRegister" placeholder="Password" required>
                  <label for="inputPassword">Password</label>
                </div>

                <div class="form-label-group">
                  <input type="password" id="repeatPassword" class="form-control"
                    placeholder="Repeat Password" required>
                  <label for="repeatPassword">Repeat Password
                  <span id='message'></span>
                  </label>
                </div>

                <div class="form-label-group">
                  <input id="inputTelephone" class="form-control"
                  name="telUsrRegister" placeholder="Telephone Number" required>
                  <label for="inputTelephone">Telephone</label>
                </div>
                <div class="form-label-group">
                  <input  type="email" id="inputEmail" class="form-control"
                  name="emailUsrRegister"   placeholder="Email" required>
                  <label for="inputEmail">Address</label>
                </div>
                <div class="form-label-group">
                  <input  type="text" id="inputDirection" class="form-control"
                  name="addrUsrRegister"   placeholder="Address" required>
                  <label for="inputDirection">Address</label>
                </div>



                <div class="custom-control custom-checkbox mb-3">
                  <input type="checkbox" class="custom-control-input"
                    id="customCheck1">
                  <label class="custom-control-label" for="customCheck1">Remember
                    password</label>
                </div>
                <button class="btn btn-lg btn-primary btn-block text-uppercase"
                  type="submit">Sign in</button>
                <hr class="my-4">
                <a href="">Create Account</a>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer -->
    <footer>
        <footer class="py-5 bg-dark">
            <div class="container">
              <p class="m-0 text-center text-white">Copyright &copy; WatchBands 2019</p>
            </div>
    </footer>
    <script src="vendor/jquery/js/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="public/js/login.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script
      src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
    <script src="public/js/loader.js"></script>
  </body>
  <footer>

  </footer>

</html>