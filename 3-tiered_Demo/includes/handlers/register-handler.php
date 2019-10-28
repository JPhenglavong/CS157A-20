<?php 

if(isset($_POST['registerButton'])) {
	//Register button was pressed
	$username = sanitizeFormUsername($_POST['username']);
	$firstName = sanitizeFormString($_POST['firstName']);
	$lastName = sanitizeFormString($_POST['lastName']);
	$email = sanitizeFormString($_POST['email']);
	$password = sanitizeFormPassword($_POST['password']);
	$password2 = sanitizeFormPassword($_POST['password2']);

	$wasSuccessful = $account->register($username, $firstName, $lastName, $email, $password, $password2);

	if($wasSuccessful == true) {
        $_SESSION['userLoggedIn'] = $username;
		header("Location: index.php");
	}else{
		echo "error";
	}
	echo $firstName; //test if successful
}

function sanitizeFormPassword($inputText) {
	$inputText = strip_tags($inputText);
	return $inputText;
}

function sanitizeFormUsername($inputText) {
	//The strip_tags() function is used to strip HTML and PHP tags from a string.
	$inputText = strip_tags($inputText);
	$inputText = str_replace(" ", "", $inputText);
	return $inputText;
}

function sanitizeFormString($inputText) {
	$inputText = strip_tags($inputText);
	$inputText = str_replace(" ", "", $inputText);
	//The ucfirst() function is used to convert the first character of a string to uppercase.
	$inputText = ucfirst(strtolower($inputText));
	return $inputText;
}





?>