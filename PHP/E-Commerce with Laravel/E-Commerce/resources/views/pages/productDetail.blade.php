@extends('layouts.app', ['activePage' => 'product', 'titlePage' => __('Product Detail')])

@section('content')
<div class="content">
  <!--Section list -->
  <div class="container">
        <div class="row">
                <div class="col-md-12 text-right">
                  <a href="{{ route('table') }}" class="btn btn-sm btn-primary">{{ __('Back to list') }}</a>
                </div>
              </div>
    <div class="row">
      <div class="col-xs-12 col-sm-12  col-md-12 col-lg-12 col-xl-12">
        <div class="card-deck"> 
          <div class="card" style="width:100px">
             <h2 class="card-title">SKU: {{$product->SKU}}</h2>
          <img class="card-img-top" style="width:60% " src="{{$product->img_p}}" alt="Card image">
            <div class="card-body">
              <h2 class="card-title">{{$product->name_p}}</h2>
            <p>{{$product->desc_p}}</p>
              <h3 class="card-text">Category: {{$product->category->name}}</h3>
              <h3 class="card-text">Stock: {{$product->stock_p}}</h3>
              <h4 class="card-text">${{$product->price_p}}</h4>
              <a href="{{route('cart',$product->id)}}" class="btn btn-success">Add to cart</a>
            </div>
          </div>
         
        </div>
      </div>
    </div>
    <div>
    </div>
    @endsection