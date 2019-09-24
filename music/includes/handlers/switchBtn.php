<?php
function switchButton($buttonName){
    if(isset($_POST[$buttonName])) {
        echo '<script>
                $(document).ready(function() {
                    $("#loginForm").hide();
                    $("#registerForm").show();
                });
            </script>';     
    }
    else {
        echo  '<script>
                $(document).ready(function() {
                    $("#loginForm").show();
                    $("#registerForm").hide();
                });
            </script>';
    }
}
?>