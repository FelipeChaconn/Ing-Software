@extends('layouts.app', ['activePage' => 'product', 'titlePage' => __('Products')])
@section('content')
<div class="content">
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <div class="card">
          <div class="card-header card-header-warning">
            <h4 class="card-title">Products </h4>
            <form action="">
              <div class="form-group">
                <h3>Filter by category:</h3>
                <select class="form-control col-lg-2">
                  @foreach($products as $product)
                  <option value="" selected disabled hidden>All</option>
                <option value="{{$product->category->id}}">{{$product->category->name}}</option>
                  @endforeach
                </select>
              </div>
            </form>
          </div>
          <div class="card-body table-responsive">
              @if (session('status'))
              <div class="row">
                <div class="col-sm-12">
                  <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <i class="material-icons">close</i>
                    </button>
                    <span>{{ session('status') }}</span>
                  </div>
                </div>
              </div>
            @endif
            <div class="row">
                <div class="col-12 text-right">
                  <a href="{{ route('product-add') }}" class="btn btn-sm btn-warning">{{ __('Add Product') }}</a>
                </div>
              </div>
            <table class="table table-hover">
              <thead class="text-sondary">
                <th>
                  {{ __('SKU') }}
                </th>
                <th>
                  {{ __('Name') }}
                </th>
                <th>
                  {{ __('Details') }}
                </th>
                <th>
                  {{ __('Price') }}
                </th>
                <th>
                  {{ __('Stock') }}
                </th>
                <th>
                  {{ __('Category') }}
                </th>
                <th class="text-right">
                  {{ __('Actions') }}
                </th>
              </thead>
              <tbody>
                  @foreach($products as $product)
                  <tr>
                      <td>
                        {{ $product->SKU }}
                      </td>
                      <td>
                        {{ $product->name_p }}
                      </td>
                      <td>
                        {{ $product->desc_p }}
                      </td>
                      <td>
                          {{ $product->price_p }}
                        </td>
                        <td>
                            {{ $product->stock_p }}
                          </td>
                          <td>
                              {{ $product->category->name }}
                            </td>
                      <td class="td-actions text-right">
                          <form action="{{route('product-destroy',$product->id)}}" method="post">
                              @csrf
                              @method('delete')
                              <a rel="tooltip" class="btn btn-success btn-link" href="{{ route('product-edit', $product->id) }}" data-original-title="" title="">
                                <i class="material-icons">edit</i>
                                <div class="ripple-container"></div>
                              </a>
                              <button type="button" class="btn btn-danger btn-link" data-original-title="" title="" onclick="confirm('{{ __("Are you sure you want to delete this user?") }}') ? this.parentElement.submit() : ''">
                                  <i class="material-icons">close</i>
                                  <div class="ripple-container"></div>
                              </button>
                          </form>
                      
                      </td>
                    </tr>
                  @endforeach
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <div class="row">

      <div class="row">

      </div>

    </div>
  </div>
</div>
@endsection

@push('js')
<script>
  $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();
    });
</script>
@endpush