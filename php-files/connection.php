<?php
$host = 'localhost';         // Database host (usually localhost)
$username = 'root'; // Your MySQL username
$password = ""; // Your MySQL password
$dbname = 'attendanceDB';   // Your database name

// Create a connection
$conn = mysqli_connect($host, $username, $password, $dbname);

// Check the connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
else{

    echo"success";
}
?>
