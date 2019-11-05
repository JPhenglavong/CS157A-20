<?php
	ob_start();
    session_start();  //further more information about session_start() visit: https://www.w3schools.com/php/php_sessions.asp
/*  The session_start() function must be the very first thing in your document. Before any HTML tags. */

	$timezone = date_default_timezone_set("Europe/London");//google search php timezone

	$con = mysqli_connect("localhost", "root", "", "team20");
	if($con){
        echo "Connected database successfully";
    }
	if(mysqli_connect_errno()) {//Return an error description from the last connection error
		echo "Failed to connect: " . mysqli_connect_errno();
	}
	
?>