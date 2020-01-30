<div class="sidebar" data-color="orange" data-background-color="white" data-image="{{ asset('material') }}/img/sidebar-1.jpg">
  <!--
      Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

      Tip 2: you can also add an image using data-image tag
  -->
  <div class="logo">
    <span class="simple-text logo-normal">
      {{ __('admin home') }}
    </span>
  </div>
  <div class="sidebar-wrapper">
    <ul class="nav">
      <li class="nav-item{{ $activePage == 'dashboard' ? ' active' : '' }}">
        <a class="nav-link" href="{{ route('admin.home') }}">
          <i class="material-icons">dashboard</i>
            <p>{{ __('Dashboard') }}</p>
        </a>
      </li>
      <li class="nav-item {{ ($activePage == 'profile' || $activePage == 'user-management') ? ' active' : '' }}">
        <a class="nav-link" data-toggle="collapse" href="#laravelExample" aria-expanded="true">
          <i><img style="width:25px" src="{{ asset('material') }}/img/user.svg"></i>
          <p>{{ __('Clients') }}
            <b class="caret"></b>
          </p>
        </a>
        <div class="collapse show" id="laravelExample">
          <ul class="nav">
            <li class="nav-item{{ $activePage == 'profile' ? ' active' : '' }}">
              <a class="nav-link" href="{{ route('profile.edit') }}">
                <span class="sidebar-mini"> YP </span>
                <span class="sidebar-normal">{{ __('Your Profile') }} </span>
              </a>
            </li>
            <li class="nav-item{{ $activePage == 'user-management' ? ' active' : '' }}">
              <a class="nav-link" href="{{ route('user.index') }}">
                <span class="sidebar-mini"> UM </span>
                <span class="sidebar-normal"> {{ __('User Management') }} </span>
              </a>
            </li>
          </ul>
        </div>
      </li>

      <li class="nav-item {{ ($activePage == 'category') ? ' active' : '' }}">
        <a class="nav-link" data-toggle="collapse" href="#CategoryMant" aria-expanded="true">
          <i><img style="width:25px" src="{{ asset('material') }}/img/category.svg"></i>
          <p>{{ __('Management Category ') }}
            <b class="caret"></b>
          </p>
        </a>
        <div class="collapse show" id="CategoryMant">
          <ul class="nav">
            <li class="nav-item{{ $activePage == 'category' ? ' active' : '' }}">
              <a class="nav-link" href="{{ route('category-list') }}">
                <span class="sidebar-mini">C</span>
                <span class="sidebar-normal">{{ __('Categories') }} </span>
              </a>
            </li>
          </ul>
        </div>
      </li>


     <li class="nav-item {{ ($activePage == 'product' || $activePage == 'product-edit') ? ' active' : '' }}">
        <a class="nav-link" data-toggle="collapse" href="#ProductsMant" aria-expanded="true">
          <i><img style="width:25px" src="{{ asset('material') }}/img/box.svg"></i>
          <p>{{ __('Management Products ') }}
            <b class="caret"></b>
          </p>
        </a>
        <div class="collapse show" id="ProductsMant">
          <ul class="nav">
            <li class="nav-item{{ $activePage == 'product' ? ' active' : '' }}">
              <a class="nav-link" href="{{ route('product-list') }}">
                <span class="sidebar-mini">AP</span>
                <span class="sidebar-normal">{{ __('Products') }} </span>
              </a>
            </li>
            <li class="nav-item{{ $activePage == 'product-edit' ? ' active' : '' }}">
              <a class="nav-link" href="{{ route('table') }}">
                <span class="sidebar-mini"> PE </span>
                <span class="sidebar-normal"> {{ __('Product view') }} </span>
              </a>
            </li>
          </ul>
        </div>
      </li>
    </ul>
  </div>
</div>