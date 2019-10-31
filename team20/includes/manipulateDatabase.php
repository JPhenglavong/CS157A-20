<?php

function getDataFromAlbums($query){
    while($row = mysqli_fetch_array($query)){
        echo "<div class='gridViewItem'>
                <a href='albumPage.php?id=" . $row['id'] . "'>
                    <img src='" . $row['artworkPath'] . "'>

                    <div class='gridViewInfo'>"
                        . $row['title'] .
                    "</div>
                </a>
            </div>";
    }
}


?>