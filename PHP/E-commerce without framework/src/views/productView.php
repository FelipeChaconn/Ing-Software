<?php
include_once 'src/controller/category_controller.php';
include_once 'src/controller/product_controller.php';
$category = new Category();
$product = new Product();
?>
  <div>
    <h1 class="col-xs-8  text-center title">Product Details</h1>
  </div>
<section>



        <div class="container">
            <div class="row">
                <div class="">
                    <br />
                    <div class="card-columns">

                        <?php
                        if (isset($_GET['id'])) {
                            $product->getProductByID($_GET['id']);
                        }else {
                            // Simple error to display if the id wasn't specified
                            die ('Product does not exist!');
                        } ?>



                    </div>
                </div>
            </div>
        </div>
    </section>