<?php

$page = isset($_GET['u'])? strtolower($_GET['u']):'userHome_view';


require_once 'src/views/user_header.php';

require_once 'src/views/'.$page.'.php';

require_once 'src/views/user_footer.php';