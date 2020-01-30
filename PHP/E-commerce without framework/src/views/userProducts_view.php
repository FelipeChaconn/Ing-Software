<?php
include_once 'src/controller/category_controller.php';
include_once 'src/controller/product_controller.php';
$category = new Category();
$product = new Product();
?>

<main>
    <div>
        <h1 class="col-xs-8  text-center title">Products</h1>
        <p><?=$product->totalProducts()?> Products</p>
    </div>
    <div>
        <div class="container">
            <div class="row col-xs-12 col-sm-12 col-lg-6 col-xl-4">
                <form action="" method="POST">
                    <select class="form-control" name="categoryName" id="categoryID" required>
                        <option value="" disabled selected>Find with Category</option>
                        <?php $category->setCatInView(); ?>
                    </select>
                  <div class="">
                    <button type="submit"  name="submit" class="btn btn-light">Filter</button>
                <div>
                </form>
            </div>
        </div>
    </div>
    <!--Section list -->
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12  col-md-12 col-lg-12 col-xl-12">
                    <br />
                    <div class="card-columns">

                        <?php
                        if (isset($_POST["submit"])) {
                            $val = $_POST['categoryName'];
                            $product->getProductByIdCategory($val);
                        }else{
                            $product->setProductsView(); 
                        } ?>



                    </div>
                </div>
            </div>
        </div>
    </section>
</main>