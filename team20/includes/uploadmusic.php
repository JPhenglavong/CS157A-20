<?php
echo '<body style="background-color:lightblue">';
$con = mysqli_connect("localhost", "root", "", "team20");
if($con){
    echo "Good Connection";
}

if(mysqli_connect_errno()) {//Return an error description from the last connection error
    echo "Failed to connect: " . mysqli_connect_errno();
}

echo "<br>";
echo"Please upload one of your music to the below box";
if(isset($_POST['submit'])){
    $name= $_FILES['file']['name'];
    $temp=$_FILES['file']['tmp_name'];

    move_uploaded_file($temp,"musics/".$name);
    $url = "http://localhost/team20/includes/musics/$name";
    //mysql_query("INSERT INTO 'music' VALUE ('','$name','$url')");
    $insertMusic = mysqli_query($con, "INSERT INTO musics VALUES ('','$name','$url')");
    //echo "Good we get that music <br>";
    //mysql_query();
}

?>

<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Upload music to web</title>
    <style>
        /*background-color: lightblue;*/
        p {
            color: springgreen;
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="uploadmusic.php" method="POST" ENCTYPE="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" name="submit" value="upload"/>
        <?php
            if(isset($_POST['submit'])){
                echo "<br/>".$name." has been uploaded";
            }
        ?>
<!--        <p> testing line</p>-->
    </form>


    <a href ="music.php"> Your music List </a>
</body>
</html>
