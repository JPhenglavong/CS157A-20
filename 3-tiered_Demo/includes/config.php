<?php
	ob_start();
    session_start();  //further more information about session_start() visit: https://www.w3schools.com/php/php_sessions.asp
/*  The session_start() function must be the very first thing in your document. Before any HTML tags. */

	$timezone = date_default_timezone_set("America/Los_Angeles");//google search php timezone



	/**
	* For security function
	*/
	function encryptPassword($password){
		$salt1 = "*&g!";
		$salt2 = "hb%$";
		$token = hash('ripemd128', "$salt1$password$salt2");
		return $token;
	}

	//sanitazing from MySQL
	function mysql_fix_string($connection, $string)
	{
		if(get_magic_quotes_gpc())
			$string = stripslashes($string);
		return $connection->real_escape_string($string);
	}

	//sanitazing from HTML
	function mysql_entities_fix_string($connection, $string)
	{
		return htmlentities(mysql_fix_string($connection, $string));
	}




	$con = mysqli_connect("127.0.0.1", "root", "yourpasswordhere", "yourDBnamehere");
	if($con){
        echo "Connected database successfully";
    }

	if(mysqli_connect_errno()) {//Return an error description from the last connection error
		echo "Failed to connect: " . mysqli_connect_errno();
	}

?>
