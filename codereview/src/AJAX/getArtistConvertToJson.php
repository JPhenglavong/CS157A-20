<?php
include("../config.php");

if(isset($_POST['artistId'])){
    $artistId = $_POST['artistId'];

    $query = mysqli_query($con, "SELECT * FROM artists WHERE id ='$artistId'");

    $resultArray = mysqli_fetch_array($query);
    //Fetch a result row as a numeric array and as an associative array:

    echo json_encode($resultArray);
    //The json_encode() function is an inbuilt function in PHP which is used to 
    //convert PHP array or object into JSON representation. 
}
?>