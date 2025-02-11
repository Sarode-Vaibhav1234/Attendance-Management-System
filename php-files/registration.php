<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

include("connection.php");   

$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // if (isset($_POST["username"])) {
        $username = $_POST["username"];
        $email = $_POST["email"];
        $password = $_POST["password"];
        $department = $_POST["department"];
        $phone = $_POST["phone"];

        $checkQuery = "SELECT id FROM teachers WHERE username = '$username'";
        $checkResult = mysqli_query($conn, $checkQuery);

        if (mysqli_num_rows($checkResult) > 0) {
            // Username already exists
            $response["status"] = "failed";
            $response["message"] = "Username already exists";
        }

       else{
        $sql = "INSERT INTO teachers (username,email, password,department,phone) VALUES ('$username', '$email', '$password', '$department','$phone')";
        $result = mysqli_query($conn, $sql);

        if ($result) {
            $response["status"] = "success";
        } else {
            $response["status"] = "failed";
            $response["error"] = mysqli_error($conn); 
        }
    }
    // } else {
    //     $response["status"] = "failed";
    //     $response["message"] = "Missing required fields";
    // }

} else {
    $response["status"] = "failed";
    $response["message"] = "Invalid request method";
}

header('Content-Type: application/json');
echo json_encode($response);
?> 

