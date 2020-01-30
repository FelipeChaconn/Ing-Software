<?php
//This do the petition get and set view Default
$page = isset($_GET['a'])? strtolower($_GET['a']):'adminHome_view';

require_once 'src/views/admin_header.php';

require_once 'src/views/'.$page.'.php';

require_once 'src/views/admin_footer.php';