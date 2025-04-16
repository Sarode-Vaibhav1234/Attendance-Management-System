<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

include("connection.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $username = $_POST["username"];
    $password = $_POST["password"];

    $checkQuery = "SELECT id FROM teachersSignup WHERE username = '$username' AND password = '$password'";
    $checkResult = mysqli_query($conn, $checkQuery);

    if (mysqli_num_rows($checkResult) > 0) {
        // Username already exists
        $response["status"] = "success";
    }

    else{
        $response["status"] = "failed";
        $response["message"] = "Invalid credentials";
    }

header('Content-Type: application/json');
echo json_encode($response);
}

?>