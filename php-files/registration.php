<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

include("connection.php");   

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['mobile'])) {
        $name = $_POST["name"];
        $mobile = $_POST["mobileno"];
        $email = $_POST["email"];
        $password = $_POST["password"];

        $sql = "INSERT INTO users (name, mobile, email, password) VALUES ('$name', '$mobile', '$email', '$password')";
        $result = mysqli_query($conn, $sql);

        $response = array();
        if ($result) {
            $response["status"] = "success";
        } else {
            $response["status"] = "failed";
            $response["error"] = mysqli_error($conn); // Show SQL error if any
        }
    } else {
        $response["status"] = "failed";
        $response["message"] = "Missing required fields";
    }
} else {
    $response["status"] = "failed";
    $response["message"] = "Invalid request method";
}

header('Content-Type: application/json');
echo json_encode($response);
?>
