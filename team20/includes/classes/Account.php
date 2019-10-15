<?php
	class Account {

		private $con;
		private $errorArray;

		public function __construct($con) {
			$this->con = $con;
			$this->errorArray = array();
		}

        public function login($un, $pw)
        {
//            $pw = md5($pw);
            $pw = sha1($pw);  //The sha1() function uses the US Secure Hash Algorithm 1.
            $query=mysqli_query($this->con,"SELECT * FROM users WHERE username='$un' AND password='$pw'");
            if (mysqli_num_rows($query) == 1) {
                return true;
            } else {
                array_push($this->errorArray, Constants::$loginFailed);
                return false;
            }
        }

		public function register($un, $fn, $ln, $em, $pw, $pw2) {
			$this->validateUsername($un);
			$this->validateFirstName($fn);
			$this->validateLastName($ln);
			$this->validateEmails($em);
			$this->validatePasswords($pw, $pw2);

			if(empty($this->errorArray) == true) {//empty — Determine whether a variable is empty
				//Insert into db
				return $this->insertUserDetails($un, $fn, $ln, $em, $pw);
			}
			else {
				return false;
			}

		}

		public function getError($error) {
			if(!in_array($error, $this->errorArray)) {//Checks if a value exists in an array
				$error = "";
			}
			return "<span class='errorMessage'>$error</span>";
		}

		/**
		 * For security function
		 */
		public function encryptPassword($password){
			$salt1 = "*&g!";
			$salt2 = "hb%$";
			$token = hash('ripemd128', "$salt1$password$salt2");
			return $token;
		}

		//sanitazing from MySQL
		public function mysql_fix_string($connection, $string)
		{
			if(get_magic_quotes_gpc())
				$string = stripslashes($string);
			return $connection->real_escape_string($string);
		}

		//sanitazing from HTML
		public function mysql_entities_fix_string($connection, $string)
		{
			return htmlentities(mysql_fix_string($connection, $string));
		}

		private function insertUserDetails($un, $fn, $ln, $em, $pw) {
//			$encryptedPw = md5($pw);            //Password ->  8b1a9953c4611296a827abf8c47804d7
			//or we w3c school find the example, md5 is a  The MD5 Message-Digest Algorithm
            $encryptedPw = sha1($pw); //The sha1() function uses the US Secure Hash Algorithm 1.
			$profilePic = "assets/images/profile-pics/head_emerald.png";
			$date = date("Y-m-d");

			$result = mysqli_query($this->con, "INSERT INTO users VALUES (NULL, '$un', '$fn', '$ln', '$em', '$encryptedPw', '$date', '$profilePic')");

			return $result;
		}

		private function validateUsername($un) {

			if(strlen($un) > 25 || strlen($un) < 3) {
				array_push($this->errorArray, Constants::$usernameCharacters);
				return;
			}

			$checkUsernameQuery = mysqli_query($this->con,"SELECT username FROM users WHERE username='$un'");
            if (mysqli_num_rows($checkUsernameQuery) != 0) {//Return the number of rows in a result set
                array_push($this->errorArray, Constants::$usernameTaken);
                return;
            }
		}

		private function validateFirstName($fn) {
			if(strlen($fn) > 25 || strlen($fn) < 2) {
				array_push($this->errorArray, Constants::$firstNameCharacters);
				return;
			}
		}

		private function validateLastName($ln) {
			if(strlen($ln) > 25 || strlen($ln) < 2) {
				array_push($this->errorArray, Constants::$lastNameCharacters);
				return;
			}
		}

		private function validateEmails($em) {

		    /* The filter_var() function filters a variable with the specif ied filter. 
			This function is used to both validate and sanitize the data. */
			if(!filter_var($em, FILTER_VALIDATE_EMAIL)) {
				array_push($this->errorArray, Constants::$emailInvalid);
				return;
			}

			//TODO: Check that username hasn't already been used
            $checkEmailQuery = mysqli_query($this->con,"SELECT email FROM users WHERE email='$em'");
            if (mysqli_num_rows($checkEmailQuery) != 0) {//Return the number of rows in a result set
                array_push($this->errorArray, Constants::$emailTaken);
                return;
            }
		}

		private function validatePasswords($pw, $pw2) {
			
			if($pw != $pw2) {
				array_push($this->errorArray, Constants::$passwordsDoNoMatch);
				return;
			}

			if(preg_match('/[^A-Za-z0-9]/', $pw)) {
				array_push($this->errorArray, Constants::$passwordNotAlphanumeric);
				return;
			}

			if(strlen($pw) > 30 || strlen($pw) < 5) {
				array_push($this->errorArray, Constants::$passwordCharacters);
				return;
			}

		}


	}
?>