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






