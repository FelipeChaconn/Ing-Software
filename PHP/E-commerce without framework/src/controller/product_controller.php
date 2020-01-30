<?php
include 'src/model/sql_product.php';
class Product extends sql_product
{
    private $sku_p;
    private $name_p;
    private $desc_p;
    private $img_p;
    private $cat_p;
    private $stock_p;
    private $price_p;


    /**
     * Get category by id to put in select
     *@id
     * 
     */
    public function getCategoryById($id)
    {
        $query =  $this->connect()->prepare("SELECT name FROM category WHERE id = :id");
        $query->execute(['id' => $id]);
        if ($query->rowCount()) {

            $cat_name = $query->fetch()['name'];
            return $cat_name;
        }
    }

    /**
     * GET on specific product from the database and show in ADMIN
     *
     * 
     */
    public function getProduct()
    {
        $query = $this->connect()->prepare('SELECT * FROM product');
        $query->execute();
        if ($query->rowCount() != 0) {
            foreach ($query as $currentProduct) {
                $this->sku_p = $currentProduct['SKU'];
                $this->name_p = $currentProduct['nameP'];
                $this->desc_p = $currentProduct['descP'];
                $this->img_p = $currentProduct['imgP'];
                $this->cat_p = $currentProduct['category_id'];
                $this->stock_p = $currentProduct['stockP'];
                $this->price_p = $currentProduct['priceP'];
                $categoryName = $this->getCategoryById($this->cat_p);
                echo "<!--Create element about data query -->
            <div class='card text-center'>
                <div class='card-header bg-dark text-white d-flex justify-content-between align-items-center'>
                    <!--title-->" . $this->name_p . "
                    <form method='POST' >
                    <input type='hidden' name='id_Delete' value='".$this->sku_p."'>
                    <button sclass='btn btn-danger'  type= 'submit'> 
                        <i class='far fa-trash-alt'></i>
                    </button>
                    </form>
                </div>
                <img src='" . $this->img_p . "' class='card-img-top' alt='Card image cap'>
                <div class='card-body'>
                    <p>
                        <!--category-->Category of product: <span id='quantity'>" . $categoryName . "</span> </p>
                    <p>
                        <!--category-->Quantity: <span id='quantity'>" . $this->stock_p . "</span></p>
                    <p>
                        <!--Name-->Description: <span id='descShow'>" . $this->desc_p . "</span></p>
                    <h4>
                        <!--title-->price: $ <span id='priceShow'>" . $this->price_p . "</span></h4>
    
                    <button class='btn btn-info btn-block'>
                        Edit
                    </button>
                </div>
            </div>";
            }
        } else {
            echo "YOu Dont Have registers";
        }
    }


    /**
     * GET on specific product from the database
     *
     * 
     */
    public function totalProducts()
    {
        $query = $this->connect()->prepare('SELECT * FROM product');
        $query->execute();
        if ($query->rowCount()) {
            return $query->rowCount();
        } else {
            return "0";
        }
    }
    /**
     * GET on specific product from the database by category id
     *
     * 
     */
    public function getProductByIdCategory($idCat)
    {
        $query = $this->connect()->prepare('SELECT * FROM product WHERE category_id= :idCat');
        $query->execute(['idCat' => $idCat]);
        if ($query->rowCount() != 0) {
            foreach ($query as $currentProduct) {
                $this->sku_p = $currentProduct['SKU'];
                $this->name_p = $currentProduct['nameP'];
                $this->desc_p = $currentProduct['descP'];
                $this->img_p = $currentProduct['imgP'];
                $this->cat_p = $currentProduct['category_id'];
                $this->stock_p = $currentProduct['stockP'];
                $this->price_p = $currentProduct['priceP'];
                $categoryName = $this->getCategoryById($this->cat_p);
                echo "
                  
                    <div class='card text-center'>
                    <div class='card-header bg-dark text-white d-flex justify-content-between align-items-center'>
                        <!--title-->" . $this->name_p . "
                     
                    </div>
                    <img src='" . $this->img_p . "' class='card-img-top' alt='Card image cap'>
                    <div class='card-body'>
                       
                           <p> <!--Name-->Description: <span id='descShow'>" . $this->desc_p . "</span></p>
                        <h4>
                            <!--title-->price: $ <span id='priceShow'>" . $this->price_p . "</span></h4>
        
                        <a href='?u=productView&id=" . $this->sku_p . "' class='btn btn-info btn-block'>
                         View
                        </a>
                    </div>
                </div>
              
           ";
            }
        } else {
            echo "YOu Dont Have registers";
        }
    }


    /**
     * GET all products from the database
     *
     * 
     */
    public function setProductsView()
    {
        $query = $this->connect()->prepare('SELECT * FROM product');
        $query->execute();
        if ($query->rowCount() != 0) {
            foreach ($query as $currentProduct) {
                $this->sku_p = $currentProduct['SKU'];
                $this->name_p = $currentProduct['nameP'];
                $this->desc_p = $currentProduct['descP'];
                $this->img_p = $currentProduct['imgP'];
                $this->cat_p = $currentProduct['category_id'];
                $this->stock_p = $currentProduct['stockP'];
                $this->price_p = $currentProduct['priceP'];
                $categoryName = $this->getCategoryById($this->cat_p);
                echo "  <form method='POST'>
                    <div class='card text-center'>
                    <div class='card-header bg-dark text-white d-flex justify-content-between align-items-center'>
                        <!--title-->" . $this->name_p . "
                     
                    </div>
                    <img src='" . $this->img_p . "' class='card-img-top' alt='Card image cap'>
                    <div class='card-body'>
                      
                           <p> <!--Name-->Description: <span id='descShow'>" . $this->desc_p . "</span></p>
                        <h4>
                            <!--title-->price: $ <span id='priceShow'>" . $this->price_p . "</span></h4>
        
                            <a href='?u=productView&id=" . $this->sku_p . "' class='btn btn-info btn-block'>
                            View
                           </a>
                    </div>
                </div>
                </form>";
            }
        } else {
            echo "YOu Dont Have registers";
        }
    }

    /**
     * GET  products from the database by SKU
     *
     * 
     */
    public function getProductByID($sku)
    {

        $query = $this->connect()->prepare("SELECT * FROM product WHERE SKU = :sku");
        $query->execute(['sku' => $sku]);
        if ($query->rowCount() != 0) {
            foreach ($query as $currentProduct) {
                $this->sku_p = $currentProduct['SKU'];
                $this->name_p = $currentProduct['nameP'];
                $this->desc_p = $currentProduct['descP'];
                $this->img_p = $currentProduct['imgP'];
                $this->cat_p = $currentProduct['category_id'];
                $this->stock_p = $currentProduct['stockP'];
                $this->price_p = $currentProduct['priceP'];
                $categoryName = $this->getCategoryById($this->cat_p);
                echo " 
                <div>
                <img src='" . $this->img_p . "'  width='500' height='500' alt='" . $this->name_p . "'>
                <div>
                <div class='card text-left'>
                <div class='card-header  d-flex justify-content-between align-items-center'>
                   <h1> <!--title-->" . $this->name_p . " </h1>
                   <h5> Serial: <span id='descShow'>" . $this->sku_p . "</span></h5>
                </div>
               
                <div class='card-body'>
                <p>  <!--Name-->Category: <span id='descShow'>" . $categoryName . "</span></p>
                      <p>  <!--Name-->Description: <span id='descShow'>" . $this->desc_p . "</span></p>
                    <h4><!--title-->price: $ <span id='priceShow'>" . $this->price_p . "</span></h4>
                    <form action='?u=userCart_view' method='POST'>
                    <input value='" . $this->sku_p . "' type='hidden' name='product_id'>
                    <p>Quantity: <input type='number' name='quantity' value='1' min='1' max='" . $this->stock_p . "' placeholder='Quantity' required></p>
                      <input class='btn btn-info btn-block' type='submit'  value='Add to Cart'> 
                </div>
            </div>";
            }
        }
    }
    /** 
     * GET  products from the database by SKU
     *
     * 
     */
    public function productById($sku)
    {
        $query = $this->connect()->prepare("SELECT * FROM product WHERE SKU = :sku");
        $query->execute(['sku' => $sku]);
        if ($query->rowCount() != 0) {
            $productResult = $query->fetch(PDO::FETCH_ASSOC);
            return $productResult;
        }
        return $productResult;
    }
/** 
     * GET  session Cart and create products array in cart
     *
     * 
     */
    public function productsInCart()
    {
        $products_in_cart = isset($_SESSION['cart']) ? $_SESSION['cart'] : array();
        return $products_in_cart;
      
    }

    /** 
     * GET  session Cart and send products array  and others to show in cart
     *
     * 
     */
    public function setProductInCart()
    {
        // If the user clicked the add to cart button on the product page we can check for the form data
        if (isset($_POST['product_id'], $_POST['quantity'])  && is_numeric($_POST['quantity'])) {
            // Set the post variables so we easily identify them, also make sure they are integer
            $product_id = $_POST['product_id'];
            $quantity = (int) $_POST['quantity'];
            // Prepare the SQL statement, we basically are checking if the product exists in our databaser
            $product = $this->productById($product_id);
            // Fetch the product from the database and return the result as an Array

            // Check if the product exists (array is not empty)
            if ($product && $quantity > 0) {
                // Product exists in database, now we can create/update the session variable for the cart
                if (isset($_SESSION['cart']) && is_array($_SESSION['cart'])) {
                    if (array_key_exists($product_id, $_SESSION['cart'])) {
                        // Product exists in cart  ONLY Update quantity  (aaray_Key_exists)is to check if ["IDProduct"]exists in array or Session.
                        $_SESSION['cart'][$product_id] += $quantity;
                       
                    } else {
                        // Product is not in cart so add it
                        $_SESSION['cart'][$product_id] = $quantity;
                    }
                } else {
                    // There are no products in cart, this will add the first product to cart
                    $_SESSION['cart'] = array($product_id => $quantity);
                }
            }
        }
        // Remove product from cart, check for the URL param "remove", this is the product id, make sure it's a number and check if it's in the cart
        if (isset($_GET['remove']) && isset($_SESSION['cart']) && isset($_SESSION['cart'][$_GET['remove']])) {
            // Remove the product from the shopping cart
            unset($_SESSION['cart'][$_GET['remove']]);
        }
        // Update product quantities in cart if the user clicks the "Update" button on the shopping cart page
        if (isset($_POST['update']) && isset($_SESSION['cart'])) {
            echo"entro";
            // Loop through the post data so we can update the quantities for every product in cart
            foreach ($_POST as $k => $v) {
                if (strpos($k, 'quantity') !== false && is_numeric($v)) {
                    $id = str_replace('quantity-', '', $k);
                    $quantity = (int) $v;
                    // Always do checks and validation
                    if (is_numeric($id) && isset($_SESSION['cart'][$id]) && $quantity > 0) {
                        // Update new quantity
                        $_SESSION['cart'][$id] = $quantity;
                    }
                }
            }
        }
        // Send the user to the place order page if they click the Place Order button, also the cart should not be empty
        if (isset($_POST['placeorder']) && isset($_SESSION['cart']) && !empty($_SESSION['cart'])) {
            header('Location: index.php?page=placeorder');
            exit;
        }
        // Check the session variable for products in cart
        
       
     
        // If there are products in cart
        if ($this->productsInCart()) {
            // There are products in the cart so we need to select those products from the database
            // Products in cart array to question mark string array, we need the SQL statement to include IN (?,?,?,...etc)
            $array_to_question_marks = implode(',', array_fill(0, count($this->productsInCart()), '?'));
            $query = $this->connect()->prepare('SELECT * FROM product WHERE SKU IN (' . $array_to_question_marks . ')');
            // We only need the array keys, not the values, the keys are the id's of the products
            $query->execute(array_keys($this->productsInCart()));
            // Fetch the products from the database and return the result as an Array
            $products = $query->fetchAll(PDO::FETCH_ASSOC);
            // Calculate the subtotal
         
            return $products;
        }
    }
    /**
     * POST on specific product from the database
     *@sku, @name
     * 
     */
    public function insertProduct($sku, $name, $description, $img, $categoryId, $quantity, $price)
    {
        $query = $this->connect()->prepare("INSERT INTO product (SKU,nameP, descP,imgP,category_id,stockP,priceP) VALUES  (?,?,?,?,?,?,?)");
        $query->execute([$sku, $name, $description, $img, $categoryId, $quantity,  $price]);
        $success = "Added!";
    }


    /**
     * Delete on specific product from the database
     *@sku, @name
     * 
     */
    public function deleteProduct($id)
    {
        $query =$this->connect()->prepare( 'DELETE FROM product WHERE SKU = :id');
        $query->execute(['id'=> $id]);
        // delete id 2
    }
}
