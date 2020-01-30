<?php
include_once 'src/controller/cart_controller.php';
include_once 'src/controller/product_controller.php';
$product = new Product();
$cart = new Cart();

//var_dump($products_in_cart);
$subtotal = 0.00;
$products = ($product->setProductInCart());
$products_in_cart = $product->productsInCart();


?>

<main>
    <div class="cart content-wrapper">
        <h1>Shopping Cart </h1>
        <form action="?u=userCart_view" method="post">
            <table>
                <thead>
                    <tr>
                        <td colspan="2">Product</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Total</td>
                    </tr>
                </thead>
                <tbody>
                    <?php


                    if (empty($products)) : ?>
                        <tr>
                            <td colspan="5" style="text-align:center;">You have no products added in your Shopping Cart</td>
                        </tr>
                    <?php else :
                    //calculate subtotal
                        foreach ($products as $product) {
                            $subtotal += (float) $product['priceP'] * (int) $products_in_cart[$product['SKU']];
                            // var_dump($subtotal);
                        }
                        ?>
                        <?php foreach ($products as $productShow) :
                                ?>
                            <tr>
                                <td class="img">
                                    <a href="?u=productView&id=<?= $productShow['SKU'] ?>">
                                        <img src="<?= $productShow['imgP'] ?>" width="50" height="50" alt="<?= $productShow['nameP'] ?>">
                                    </a>
                                </td>
                                <td>
                                    <a href="?u=userCart_view&id=<?= $productShow['SKU'] ?>"><?= $productShow['nameP'] ?></a>
                                    <br>
                                    <a href="?u=userCart_view&remove=<?= $productShow['SKU'] ?>" class="remove">Remove</a>
                                </td>

                                <td class="price">&dollar;<?= $productShow['priceP'] ?></td>
                                <td class="quantity">
                                    <input type="number" name="quantity-<?= $productShow['SKU'] ?>" value="<?= $products_in_cart[$productShow['SKU']] ?>" min="1" max="<?= $product['stockP'] ?>" placeholder="Quantity" required>
                                </td>
                                <td class="price">&dollar;<?= $productShow['priceP'] * $products_in_cart[$productShow['SKU']] ?></td>
                            </tr>
                        <?php  endforeach; ?>
                    <?php endif; ?>
                </tbody>
            </table>
            <div class="subtotal">
                <span class="text">Subtotal</span>
                <span class="price">&dollar;<?= $subtotal ?></span>
            </div>
            <div class="buttons">
                <input type="submit" value="Update" name="update">
                <input type="submit" value="Place Order" name="placeorder">
            </div>
        </form>
    </div>
</main>


<!-- 


-->