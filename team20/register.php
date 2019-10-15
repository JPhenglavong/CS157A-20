<?php
	include("includes/config.php");
	include("includes/classes/Account.php");
	include("includes/classes/Constants.php");

	$account = new Account($con);

	include("includes/handlers/register-handler.php");
    include("includes/handlers/login-handler.php");
    include("includes/handlers/switchBtn.php");

?>

<html lang="">
<head>
	<title>Welcome to Streaming Music!</title>
    <link rel="stylesheet" type="text/css" href="assets/css/register.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="assets/js/register.js"></script>
</head>
<body>

<?php
switchButton('registerButton');
?>
    <div id="background">
        <div id="loginContainer">
            <div id="inputContainer">

                <form id="loginForm" action="register.php" method="POST">
                    <h2>Login to your account</h2>
                    <p>
                        <?php echo $account->getError(Constants::$loginFailed); ?>
                        <label for="loginUsername">Username</label>
                        <input id="loginUsername" name="loginUsername" type="text" placeholder="username" 
                        value="<?php getInputValue('loginUsername') ?>" required>
                    </p>
                    <p>
                        <label for="loginPassword">Password</label>
                        <input id="loginPassword" name="loginPassword" type="password" placeholder="Your password" required>
                    </p>

                    <button type="submit" name="loginButton">LOG IN</button>

                    <div class="hasAccountText">
                        <span id="hideLogin">If you don't have a account, please sign up</span>
                    </div>

                </form>

                <form id="registerForm" action="register.php" method="POST">
                    <h2>Create your free account</h2>
                    <p>
                        <?php echo $account->getError(Constants::$usernameCharacters); ?>
                        <?php echo $account->getError(Constants::$usernameTaken); ?>
                        <label for="username">Username</label>
                        <input id="username" name="username" type="text" placeholder="username" value="<?php getInputValue('username') ?>" required>
                    </p>

                    <p>
                        <?php echo $account->getError(Constants::$firstNameCharacters); ?>
                        <label for="firstName">First name</label>
                        <input id="firstName" name="firstName" type="text" placeholder="first name" value="<?php getInputValue('firstName') ?>" required>
                    </p>

                    <p>
                        <?php echo $account->getError(Constants::$lastNameCharacters); ?>
                        <label for="lastName">Last name</label>
                        <input id="lastName" name="lastName" type="text" placeholder="last name" value="<?php getInputValue('lastName') ?>" required>
                    </p>

                    <p>
                        <?php echo $account->getError(Constants::$emailInvalid); ?>
                        <?php echo $account->getError(Constants::$emailTaken); ?>
                        <label for="email">Email</label>
                        <input id="email" name="email" type="email" placeholder="name@gmail.com" value="<?php getInputValue('email') ?>" required>
                    </p>

                    <p>
                        <?php echo $account->getError(Constants::$passwordsDoNoMatch); ?>
                        <?php echo $account->getError(Constants::$passwordIsIllegal); ?>
                        <?php echo $account->getError(Constants::$passwordCharacters); ?>
                        <label for="password">Password</label>
                        <input id="password" name="password" type="password" placeholder="Your password" required>
                    </p>

                    <p>
                        <label for="password2">Confirm password</label>
                        <input id="password2" name="password2" type="password" placeholder="Your password" required>
                    </p>

                    <button type="submit" name="registerButton">SIGN UP</button>

                    <div class="hasAccountText">
                        <span id="hideRegister">Pleae log in</span>
                    </div>
                </form>

            </div>

            <div id="loginText">
                <h1>CS157A Team-20 Streaming Music </h1>
                <h2>Listen our songs for free</h2>
                <ul>
                    <li>Discover music you'll fall in love with</li>
                    <li>Create your own playlists</li>
                    <li>Follow artists to keep up to date</li>
                </ul>
            </div>

        </div>
    </div>
</body>
</html>
