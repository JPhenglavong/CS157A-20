<?php
?>

<!doctype html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Listening Active
    </title>
    <style>
        body{
            /*background-color: #000;*/
            background: url("../assets/images/bg1.jpg") no-repeat fixed center center;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            display: table;
            height: 100%;
            width: 100%;
        }

    </style>
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
