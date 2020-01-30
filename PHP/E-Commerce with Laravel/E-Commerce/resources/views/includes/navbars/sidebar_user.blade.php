<div class="sidebar" data-color="orange" data-background-color="white" data-image="{{ asset('material') }}/img/sidebar-1.jpg">
    <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"
  
        Tip 2: you can also add an image using data-image tag
    -->
    <div class="logo">
      <h3 class="simple-text logo-normal">
        {{ __('Welcome back') }}
        
      </h3>
    </div>
    <div class="sidebar-wrapper">
      <ul class="nav">
        <li class="nav-item{{ $activePage == 'dashboard' ? ' active' : '' }}">
          <a class="nav-link" href="{{ route('home') }}">
            <i class="material-icons">dashboard</i>
              <p>{{ __('Dashboard') }}</p>
          </a>
        </li>
        <li class="nav-item{{ $activePage == 'Products' ? ' active' : '' }}">
          <a class="nav-link" href="{{ route('table') }}">
            <i class="material-icons">local_offer</i>
              <p>{{ __('Products') }}</p>
          </a>
        </li>
        <li class="nav-item{{ $activePage == 'typography' ? ' active' : '' }}">
          <a class="nav-link" href="{{ route('cartShow') }}">
            <i class="material-icons">shopping_cart</i>
              <p>{{ __('Cart') }}</p>
          </a>
        </li>
  
       
      </ul>
    </div>
  </div>