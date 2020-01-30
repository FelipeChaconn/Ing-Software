<?php
include_once 'src/controller/category_controller.php';
$category = new Category();

?>

<?php 

if (isset($_POST['id_DeleteCat'])) {
  $category->deleteCategory($_POST['id_DeleteCat']);
  echo "<div class='alert alert-success  my-2 my-lg-0' role='alert'>";
echo "Delete Success";
echo"</div>";
}
if (isset($_POST['categoryName'])) {
  $catName = $_POST['categoryName'];
  $category->insertCategory($catName);
} 
 ?>



<main>
  <div>
    <h1 class="col-xs-8  text-center title">Categories</h1>
  </div>
  <div class="container">
    <div class="table-wrapper">
      <div class="table-title">
        <div class="row">
          <div class="col-sm-8">
            <h2>Categories<b>Details</b></h2>
          </div>
          <div class="col-sm-4">
            <button type="button" class="btn btn-info add-new" data-toggle="modal" data-target="#modalAddForm"><i class="fa fa-plus"></i> Add New</button>
          </div>
        </div>
      </div>
      <table class="table table-bordered   table-responsive-sm table-fixed">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
        <tbody>
          <?php
          $category->setCategoryInTable();
         
          ?>
        </tbody>
      </table>
    </div>
  </div>

</main>
<?php if(isset($_GET['id'])){?>
  <!--Modal Add-->
  <h1>ENTRO AL GET=<? var_dump($_GET['id']);?></h1>
<div class="modal fade" id="modalEditForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Add Category</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mx-3">
        <form action="" method="POST" id="categoryAdd" class="">
          <div class="md-form mb-4">
            <i class="fab fa-apple prefix grey-text"></i>
            <input type="text" id="cat" name="categoryName"   class="form-control validate" required> 
            <label data-error="wrong" data-success="right" for="cat">Category name</label>
          </div>
        </form>
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="delete btn btn-success" type="submit" form="categoryAdd">Save</button>
      </div>

    </div>
  </div>
</div>
<?php }?>
<!--Modal Add-->
<div class="modal fade" id="modalAddForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Add Category</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mx-3">
        <form action="" method="POST" id="categoryAdd" class="">
          <div class="md-form mb-4">
            <i class="fab fa-apple prefix grey-text"></i>
            <input type="text" id="cat" name="categoryName"   class="form-control validate" required> 
            <label data-error="wrong" data-success="right" for="cat">Category name</label>
          </div>
        </form>
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="delete btn btn-success" type="submit" form="categoryAdd">Save</button>
      </div>

    </div>
  </div>
</div>
<!--Modal Delete-->
<div id="modalDeleteForm" class="modal fade">
	<div class="modal-dialog modal-confirm">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box">
				<i class="fas fa-exclamation-circle"></i>
				</div>				
				<h4 class="modal-title">Are you sure?</h4>	
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
      <form action="" method="POST" id="categoryDelete" class="">
				<p>Do you really want to delete these record? This process cannot be undone.</p>
			</div>
			<div class="modal-footer">
        <button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>

				<button  class="btn btn-danger delete-confirm" name= "submit"type="submmit" form="categoryDelete" >Delete</button>
			</div>
		</div>
	</div>
</div>