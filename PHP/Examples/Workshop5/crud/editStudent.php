<?php
  include('functions.php');

  if($_GET['id']) {
    $student = getStudent($_GET['id']);
  } else {
    // header('Location: /crud/?status=error');
  }
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

  <title>Document</title>
</head>
<body>
<div class="container">
    <div class="msg">
      <?php echo $message; ?>
    </div>
    <h1>Edit Student</h1>
    <form action="/crud/editStudent.php" method="POST" class="form-inline" role="form">
      <div class="form-group">
        <label class="sr-only" for="">Full Name</label>
        <input type="text" class="form-control" id="" name="full_name" placeholder="Full Name" value="<?php echo $student['full_name'] ?>">
      </div>
      <div class="form-group">
        <label class="sr-only" for="">Email</label>
        <input type="email" class="form-control" id="" name="email" placeholder="Email" value="<?php echo $student['email'] ?>">
      </div>

      <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>

</body>
</html>