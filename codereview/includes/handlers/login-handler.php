<?php
    if(isset($_POST['loginButton'])) {
    	//Login button was pressed
        $username = $_POST['loginUsername'];
        $password = $_POST['loginPassword'];

        //Login function
        $result = $account->login($username, $password);

        if ($result == true) {
            $_SESSION['userLoggedIn'] = $username;
            header("Location: index.php");
        }
    }

	function getInputValue($name) {
		if(isset($_POST[$name])) {
			echo $_POST[$name];
		}
	}

?>