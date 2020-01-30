<div class="wrapper ">
        @include('includes.navbars.sidebar_user')
        <div class="main-panel">
          @include('includes.navbars.navs.auth_user')
          @yield('content')
          @include('includes.footers.auth')
        </div>
      </div>