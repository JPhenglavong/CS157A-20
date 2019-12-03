<?php

function getJSONformatArray($con){
    $songQuery = mysqli_query($con, "SELECT * FROM songs 
    ORDER BY RAND() LIMIT 10");
    $resultArray = array();
    while($row = mysqli_fetch_array($songQuery)){
    array_push($resultArray, $row['id']);
    }

    // foreach ($resultArray as $song => $val){
    //     echo "$song => $val <br>";
    // }
    $jsonArray = json_encode($resultArray);
    return $jsonArray;
}

    // $songQuery = mysqli_query($con, "SELECT * FROM songs 
    //                                 ORDER BY RAND() LIMIT 10");
    // $resultArray = array();
    // while($row = mysqli_fetch_array($songQuery)){
    //     array_push($resultArray, $row['id']);
    // }

    // // foreach ($resultArray as $song => $val){
    // //     echo "$song => $val <br>";
    // // }

    // $jsonArray = json_encode($resultArray);
?>