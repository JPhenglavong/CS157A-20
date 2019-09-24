<?php
include("includes/config.php");//run session_start() firstly

//session_destroy();        //this function will make you every time log out

if (isset($_SESSION['userLoggedIn'])) {
    $userLoggedIn = $_SESSION['userLoggedIn'];
}else{
    header("Location: register.php");
}

?>


<html>
<head>
	<title>Streaming Music</title>
</head>

<body>
    Welcome to CS157A Team-20 Streaming Music
</body>

</html>