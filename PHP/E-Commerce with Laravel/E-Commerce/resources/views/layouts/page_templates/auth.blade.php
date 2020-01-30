<div class="wrapper ">
  @include('includes.navbars.sidebar')
  <div class="main-panel">
    @include('includes.navbars.navs.auth')
    @yield('content')
    @include('includes.footers.auth')
  </div>
</div>