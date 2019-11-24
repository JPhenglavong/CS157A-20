<?php
?>

<!doctype html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Listening Active
    </title>
</head>
<body>
<?php
$con = mysqli_connect("localhost", "root", "", "team20");
//$loadmusic = mysqli_query($con, "SELECT * FROM musics");

if(isset($_GET['number'])){
    $id = $_GET['number'];
    $activebot= mysqli_query($con,"SELECT * FROM musics WHERE id ='$id'");
    while($attribute=mysqli_fetch_assoc($activebot)){
        $name = $attribute['name'];
        $url = $attribute['url'];
    }
    echo "You are listening to ". $name ."</br />";
    echo "<embed src ='$url'></embed>";


}else{
    echo "What is happening? Error commits";
}


?>

</body>

</html>
