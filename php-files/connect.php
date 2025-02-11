<?php
$host = 'sql103.infinityfree.com';        
$username = 'if0_38264938'; 
$password = "Attendance2266"; 
$dbname = 'if0_38264938_AttendanceDB';  

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
