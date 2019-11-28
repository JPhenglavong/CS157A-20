<?php
//echo '<body style="background-color:lightblue">';
$con = mysqli_connect("localhost", "root", "", "team20");
if($con){
    echo '<span style="color: white;font-size: 25px">Good Connection!</span>';
}

if(mysqli_connect_errno()) {//Return an error description from the last connection error
    echo "Failed to connect: " . mysqli_connect_errno();
}

echo "<br>";
echo '<span style="color: white;font-size: 25px">Please upload one of your music to the below box</span>';
if(isset($_POST['submit'])){
    $name= $_FILES['file']['name'];
    $temp=$_FILES['file']['tmp_name'];

    move_uploaded_file($temp,"musics/".$name);
    $url = "http://localhost/team20/includes/musics/$name";
    $insertMusic = mysqli_query($con, "INSERT INTO musics VALUES ('','$name','$url')");
}

?>

<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Upload music to web</title>
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
    <form action="uploadmusic.php" method="POST" ENCTYPE="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" name="submit" value="upload"/>
        <?php
            if(isset($_POST['submit'])){
                echo "<br/>";
                echo '<div style="Color:white">'.$name." has been uploaded".'</div>';
//                echo '<span style="color: white;font-size: 25px">$name. has been uploaded</span>';
//                echo "<br/>".$name." has been uploaded";
            }
        ?>
<!--        <p> testing line</p>-->
    </form>


    <a href ="music.php" style = "color: aqua"> Your music List </a>
</body>
</html>
