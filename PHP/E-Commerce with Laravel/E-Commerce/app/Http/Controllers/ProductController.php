<?php

namespace App\Http\Controllers;

use App;
use App\Http\Requests\UserRequest;
use Illuminate\Http\Request;

class ProductController extends Controller
{
  /**
     * Display a listing of the users
     *
     * @param  \App\User  $model
     * @return \Illuminate\View\View
     */
    public function index()
    {
      
        $products = App\Product::with('category')->paginate(15);
        return view('pages.products.index',compact('products'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {   
        $categories = App\Category::paginate(15);
        return view('pages.products.create',compact('categories'));
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        // return $request->all();
        $newproduct = new App\Product();
        $newproduct->SKU =  $request->SKU;
        $newproduct->name_p =  $request->name_p;
        $newproduct->desc_p =  $request->desc_p;
        $newproduct->img_p =  $request->img_p;
        $newproduct->price_p =  $request->price_p;
        $newproduct->stock_p =  $request->stock_p;
        $newproduct->category_id =  $request->category_id;
        $newproduct->save();
        return redirect()->route('product-list')->withStatus(__('Product successfully added.'));
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function list(App\Product $product)
    {
        $products = App\Product::with('category')->paginate(15);
        return view('pages.products',compact('products'));
    }
    /**
     * Display the specified  product.
     *
     * @param  \App\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function listProduct(App\Product $product, $id)
    {
        $product = App\Product::findOrFail($id);
        return view('pages.productDetail',compact('product'));
    }

    public function cart(App\Product $product){
        return view('pages.cart');
    }
    public function addToCart(App\Product $product, $id)
        {
            $product = App\Product::findOrFail($id);
     
            if(!$product) {
     
                abort(404);
     
            }
     
            $cart = session()->get('cart');
     
            // if cart is empty then this the first product
            if(!$cart) {
     
                $cart = [
                        $id => [
                            "photo"=>$product->img_p,
                            "name" => $product->name_p,
                            "quantity" => 1,
                            "price" => $product->price_p,
                            "SKU" => $product->sku_p
                        ]
                ];
     
                session()->put('cart', $cart);
     
                return redirect()->route('table')->withStatus(__('Product successfully added to cart'));
            }
     
            // if cart not empty then check if this product exist then increment quantity
            if(isset($cart[$id])) {
     
                $cart[$id]['quantity']++;
     
                session()->put('cart', $cart);
     
                return redirect()->route('table')->withStatus(__('Product successfully added to cart'));
     
            }
     
            // if item not exist in cart then add to cart with quantity = 1
            $cart[$id] = [
                "photo"=>$product->img_p,
                "name" => $product->name_p,
                "quantity" => 1,
                "price" => $product->price_p,
                "SKU" => $product->sku_p
            ];
     
            session()->put('cart', $cart);
     
            return redirect()->route('table')->withStatus(__('Product successfully added to cart'));
        }
        public function updateCart(Request $request)
    {
        if($request->id and $request->quantity)
        {
            $cart = session()->get('cart');
 
            $cart[$request->id]["quantity"] = $request->quantity;
 
            session()->put('cart', $cart);
 
            session()->flash('success', 'Cart updated successfully');
        }
    }
 
    public function remove(Request $request)
    {
        if($request->id) {
 
            $cart = session()->get('cart');
 
            if(isset($cart[$request->id])) {
 
                unset($cart[$request->id]);
 
                session()->put('cart', $cart);
            }
 
            session()->flash('success', 'Product removed successfully');
        }
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function edit(App\Product $product,$id)
    {
        $product = App\Product::findOrFail($id);
        $categories = App\Category::paginate(15);
        return view('pages.products.edit',compact('product','categories'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request,$id)
    {
        $productUpdate = App\Product::findOrFail($id);
        $productUpdate->SKU =  $request->SKU;
        $productUpdate->name_p =  $request->name_p;
        $productUpdate->desc_p =  $request->desc_p;
        $productUpdate->img_p =  $request->img_p;
        $productUpdate->price_p =  $request->price_p;
        $productUpdate->stock_p =  $request->stock_p;
        $productUpdate->category_id =  '1';
        $productUpdate->save();
        return redirect()->route('product-list')->withStatus(__('Product successfully updated'));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Product  $product
     * @return \Illuminate\Http\Response
     */
    public function destroy(App\Product $product,$id)
    {
        $categoryDelete = App\Product::findOrFail($id);
        $categoryDelete->delete();
        return redirect()->route('product-list')->withStatus(__('Product successfully deleted.'));
    }
}
