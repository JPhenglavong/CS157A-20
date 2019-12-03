//How to change css display none or block property using Jquery?
/* 
https://stackoverflow.com/questions/3582619/how-to-change-css-display-none-or-block-property-using-jquery
 */

$(document).ready(() => {
    console.log("jquery is ready.")
    $("#hideLogin").click(() => {
        console.log("login is pressed.")
        $("#loginForm").hide();
        $("#registerForm").show();
    });

    $("#hideRegister").click(() => {
        console.log("register is pressed.")
        $("#loginForm").show();
        $("#registerForm").hide();
    });
});






