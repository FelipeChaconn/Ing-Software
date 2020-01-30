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
  <script src="https://kit.fontawesome.com/a341f184c1.js" crossorigin="anonymous"></script>
  <link href="https://fonts.googleapis.com/css?family=Lora&display=swap" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="public/css/styleCategoriesAdmin.css" rel="stylesheet">
  <link href="public/css/styleAdmin.css" rel="stylesheet">
  <!-- Favicon
        –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="icon" type="image/png" href="public/assets/watchlogo.png">
</head>

<body>
 <!-- Header-->
 <header>
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-sm-12 col-12">
        </div>
        <div class="col-md-4 col-12 text-center">
          <h2 class="my-md-3 site-title white">WatchBands CR</h2>
        </div>
        <div class="col-md-4 col-12 text-right">
          <div class="btn-group">
            <button class="btn border dropdown-toggle my-md-4 my-2 white" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"><span class="fas fa-user" aria-hidden="true"></span>
            Admin   <?php echo $user->getName();  ?>
            </button>
            <div class="dropdown-menu">
              <a href="src/controller/perfil.php" class="dropdown-item"><span class="fas  fa-user-cog" aria-hidden="true"></span> Profile</a>
              <a href="src/controller/logout.php" class="dropdown-item"><span class="fas fa-sign-out-alt" aria-hidden="true"></span> Log Out</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container-fluid p-0">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="<?php echo $page == 'home'? 'active': ''; ?>">
              <a class="nav-link" href="?a=adminHome_view">Home</a>
            </li>
            <li class="<?php echo $page == 'clientes'? 'active': ''; ?>">
              <a class="nav-link" href="?a=adminClients_view">Clients</a>
            </li>
            <li class="<?php echo $page == 'categorie'? 'active': ''; ?>">
              <a class="nav-link" href="?a=adminCategories_view">Categories</a>
            </li>
            <li class="<?php echo $page == 'products'? 'active': ''; ?>">
              <a class="nav-link" href="?a=adminProducts_view">Products</a>
            </li>
            <li class="<?php echo $page == 'sales'? 'active': ''; ?>">
              <a class="nav-link" href="?a=adminSalesList_view">Sales</a>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          </form>
        </div>
      </nav>
    </div>
  </header>
  <!--/Header-->
  <!-- Main-->
 



 
