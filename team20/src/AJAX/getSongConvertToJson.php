<?php
include("../config.php");

if(isset($_POST['songId'])){
    $songId = $_POST['songId'];

    $query = mysqli_query($con, "SELECT * FROM Songs WHERE id ='$songId'");

    $resultArray = mysqli_fetch_array($query);
    //Fetch a result row as a numeric array and as an associative array:

    echo json_encode($resultArray);
    //The json_encode() function is an inbuilt function in PHP which is used to convert PHP array or object into JSON representation. 

}
?>