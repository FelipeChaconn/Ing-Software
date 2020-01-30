@extends('layouts.app', ['activePage' => 'product', 'titlePage' => __('Add Product')])
@section('content')
<div class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <form method="POST" action="{{route('product-store')}}" autocomplete="off" class="form-horizontal">
          @csrf
          <div class="card ">
            <div class="card-header card-header-warning">
              <h4 class="card-title">{{ __('Add Product') }}</h4>
              <p class="card-product"></p>
            </div>
            <div class="card-body ">
              <div class="row">
                <div class="col-md-12 text-right">
                  <a href="{{ route('product-list') }}" class="btn btn-sm btn-warning">{{ __('Back to list') }}</a>
                </div>
              </div>

              <div class="row">
                <label class="col-sm-2 col-form-label">{{ __('Product SKU:') }}</label>
                <div class="col-sm-2">
                  <div class="form-group{{ $errors->has('sku') ? ' has-danger' : '' }}">
                    <input class="form-control{{ $errors->has('sku') ? ' is-invalid' : '' }}" name="SKU" id="input-sku"
                      type="text" placeholder="{{ __('Sku number') }}" value="{{ old('sku') }}" required="true"
                      aria-required="true" />
                    @if ($errors->has('sku'))
                    <span id="sku-error" class="error text-danger" for="input-sku">{{ $errors->first('sku') }}</span>
                    @endif
                  </div>
                </div>

              </div>
              <div class="row">
                <label class="col-sm-2 col-form-label">{{ __('Product Name:') }}</label>
                <div class="col-sm-7">
                  <div class="form-group{{ $errors->has('name') ? ' has-danger' : '' }}">
                    <input class="form-control{{ $errors->has('name') ? ' is-invalid' : '' }}" name="name_p"
                      id="input-name" type="text" placeholder="{{ __('Name') }}" value="{{ old('name') }}"
                      required="true" aria-required="true" />
                    @if ($errors->has('name'))
                    <span id="name-error" class="error text-danger" for="input-name">{{ $errors->first('name') }}</span>
                    @endif
                  </div>
                </div>
              </div>
              <div class="row">
                <label class="col-sm-2 col-form-label">{{ __('Description:') }}</label>
                <div class="col-sm-7">
                  <div class="form-group{{ $errors->has('detail') ? ' has-danger' : '' }}">
                    <input class="form-control{{ $errors->has('detail') ? ' is-invalid' : '' }}" name="desc_p"
                      id="input-detail" type="text" placeholder="{{ __('Description') }}" value="{{ old('detail') }}"
                      required />
                    @if ($errors->has('detail'))
                    <span id="detail-error" class="error text-danger"
                      for="input-detail">{{ $errors->first('detail') }}</span>
                    @endif
                  </div>
                </div>
              </div>

              <div class="row">
                <label class="col-sm-2 col-form-label">{{ __('Image URL:') }}</label>
                <div class="col-sm-7">
                  <div class="form-group{{ $errors->has('img') ? ' has-danger' : '' }}">
                    <input class="form-control{{ $errors->has('img') ? ' is-invalid' : '' }}" name="img_p"
                      id="input-img" type="text" placeholder="{{ __('Image Url') }}" value="{{ old('img') }}"
                      required />
                    @if ($errors->has('img'))
                    <span id="img-error" class="error text-danger" for="input-img">{{ $errors->first('img') }}</span>
                    @endif
                  </div>
                </div>
              </div>

              <div class="row">
                <label class="col-sm-2 col-form-label">{{ __('Price:') }}</label>
                <div class="col-sm-3">
                  <div class="form-group{{ $errors->has('price') ? ' has-danger' : '' }}">
                    <input class="form-control{{ $errors->has('price') ? ' is-invalid' : '' }}" name="price_p"
                      id="input-price" type="text" placeholder="{{ __('Price') }}" value="{{ old('price') }}"
                      required />
                    @if ($errors->has('price'))
                    <span id="price-error" class="error text-danger"
                      for="input-price">{{ $errors->first('price') }}</span>
                    @endif
                  </div>
                </div>
              </div>

              <div class="row">
                <label class="col-sm-2 col-form-label">{{ __('Stock:') }}</label>
                <div class="col-sm-3">
                  <div class="form-group{{ $errors->has('stock') ? ' has-danger' : '' }}">
                    <input class="form-control{{ $errors->has('stock') ? ' is-invalid' : '' }}" name="stock_p"
                      id="input-stock" type="text" placeholder="{{ __('Stock number') }}" value="{{ old('stock') }}"
                      required />
                    @if ($errors->has('stock'))
                    <span id="stock-error" class="error text-danger"
                      for="input-stock">{{ $errors->first('stock') }}</span>
                    @endif
                  </div>
                </div>
              </div>

              <div class="row">
                <label class="col-sm-2 col-form-label">{{ __('Category:') }}</label>
                <div class="col-sm-7">
                  <div class="form-group{{ $errors->has('category') ? ' has-danger' : '' }}">
                    <select name="category_id" class="form-control col-sm-3">
                      @foreach($categories as $category)
                      <option value="" selected disabled hidden>Select Category:</option>
                      <option value="{{$category->id}}">{{$category->name}}</option>
                      @endforeach
                    </select>

                  </div>
                </div>
              </div>
              
            </div>
            <div class="card-footer ml-auto mr-auto">
              <button type="submit" class="btn btn-warning">{{ __('Add Product') }}</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
@endsection