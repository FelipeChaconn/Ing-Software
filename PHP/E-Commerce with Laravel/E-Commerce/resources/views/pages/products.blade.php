@extends('layouts.app', ['activePage' => 'products', 'titlePage' => __('Products')])

@section('content')
<div class="content">
  <!--Section list -->
  <div class="container">
    <div class="row">
      <div class="col-xs-12 col-sm-12  col-md-12 col-lg-12 col-xl-12">
        <div class="card-deck">

          @foreach ($products as $product)
          <div class="card" style="width:300px">
          <img class="card-img-top" style="width:60% " src="{{$product->img_p}}" alt="Card image">
            <div class="card-body">
              <h2 class="card-title">{{$product->name_p}}</h2>
              <h3 class="card-text">{{$product->category->name}}</h3>
              <h4 class="card-text">${{$product->price_p}}</h4>
              <a href="{{route('see-details', $product->id)}}" class="btn btn-primary">See Details</a>
            <a href="{{route('cart', $product->id)}}" class="btn btn-success">Add to cart</a>
            </div>
          </div>
          @endforeach
        </div>
      </div>
    </div>
    <div>
    </div>
    @endsection