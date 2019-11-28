<?php
?>

<!doctype html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Here is Music List from Web server
    </title>
    <style>
        body{
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
$loadmusic = mysqli_query($con, "SELECT * FROM musics");
while($attribute = mysqli_fetch_assoc($loadmusic)){
    $number = $attribute['id'];
    $name = $attribute['name'];
    echo  "<a href = 'ListenBot.php?number=$number'style = \"color: aqua\">$name</a><br />";
}
?>

</body>

</html>
