<?php
?>

<!doctype html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Here is Music List from Web server
    </title>
</head>
<body>
<?php
$con = mysqli_connect("localhost", "root", "", "team20");
$loadmusic = mysqli_query($con, "SELECT * FROM musics");
while($attribute = mysqli_fetch_assoc($loadmusic)){
    $number = $attribute['id'];
    $name = $attribute['name'];
    echo  "<a href = 'ListenBot.php?number=$number'>$name
    </a>    <br />";
}
?>

</body>

</html>
