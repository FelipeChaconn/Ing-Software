<?php
include_once 'src/controller/category_controller.php';
include_once 'src/controller/product_controller.php';
$category = new Category();
$product = new Product();
?>
<!--Get Post and add elements-->
<?php 
  if (isset($_POST['id_Delete'])) {
    $product->deleteProduct($_POST['id_Delete']);
    echo "<div class='alert alert-success  my-2 my-lg-0' role='alert'>";
  echo "Delete Success";
  echo"</div>";
  }

if (isset($_POST['titleProduct'])) {
    $sku = $_POST['skuName'];
  $titleProduct = $_POST['titleProduct'];
  $categoryID_data = $_POST['categoryID'];
  $spinnerQuantity = $_POST['spinnerQuantity'];
  $price = $_POST['price'];
  $description = $_POST['description'];
  $image = $_POST['image'];

  $product->insertProduct($sku,$titleProduct,$description,$image,$categoryID_data,$spinnerQuantity,$price);
  echo "<div class='alert alert-success  my-2 my-lg-0' role='alert'>";
  echo "Added Success";
  echo"</div>";
}else{

} ?>


<main>
    <div>
        <h1 class="col-xs-8  text-center title">Products</h1>
    </div>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-2">
                    <div class="card ">
                        <div class="card-body">
                            <form method="POST" id="productAddForm">
                                <div class="form-group ">
                                    <div class="col-sm-5 col-lg-5 col-xl-5">
                                        <input class="form-control" placeholder="SKU" name="skuName" type="text" id="skuInput" autofocus  required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="text" name="titleProduct" placeholder="Title Name" id="titleName" require>
                                </div>
                                <div class="form-group">
                                    <label for="FormControlSelect1"></label>
                                    <select class="form-control" name="categoryID" id="FormControlSelect1" require>
                                        <option value="" disabled selected>Select your category</option>
                                        <?php $category->setCategoryInSelect(); ?>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="number" value="1" min="1" max="99" name="spinnerQuantity" id="spinner" require>
                                </div>
                                <div class="form-group">
                                    <textarea class="form-control" name="description" placeholder="description" id="descInput" rows="2" require></textarea>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="number" name="price" placeholder="price" id="priceInput" require>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="url" name="image" placeholder="image" id="imgInput" require>
                                </div>
                             
                            </form>
                               <button type= "submmit" form="productAddForm" class=" btn btn-success btn-block">
                                    SAVE
                                </button>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card card-body tex-center">
                        <img src="public/assets/images/no_image.png" id="imgShow" class="card-img-top" alt="Card image product">
                        <h3 id="TitleNameShow">
                            <!--title-->Title of product</h3>
                        <p>
                            <!--category-->Category of product:</p>
                        <p>
                            <!--category-->Quantity: <span id="quantity"></span></p>
                        <p>
                            <!--Name-->Description: <span id="descShow"></span></p>
                        <h4>
                            <!--title-->price: $ <span id="priceShow"></span></h4>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--Section list -->
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12  col-md-12 col-lg-12 col-xl-12">
                    <br />
                    <div class="card-columns">


           <?php  $product->getProduct(); ?> 
                       
                        

                    </div>
                </div>
            </div>
        </div>
    </section>
</main>