<html>

<?php

$con=new mysqli("localhost:3306","root","","test");
if($con->connect_error)
    echo "Falied";
else
{     

$sql = "select * from stud";
$result = $con->query($sql);
echo "<br><p>Before deletion</p>";
echo "<br><table border=\"1\">";
echo "<tr><th>NAME</th><th>AGE</th><th>DATE</th><th>ADDRESS</th><th>PHONE</th><th>EMAIL</th></tr>";
if ($result->num_rows>0)
{
while ($row = $result->fetch_assoc())
	echo "<tr><td>".$row["name"]."</td><td>".$row["age"]."</td><td>".$row["dob"]."</td><td>".$row["addr"]."</td><td>".$row["mob"]."</td><td>".$row["email"]."</td></tr>";
}
echo "</table>";

$del = "delete from stud where name=?";
$stmt=mysqli_prepare($con,$del);
mysqli_stmt_bind_param($stmt,"s",$name);
$name=$_GET["t1"];
mysqli_stmt_execute($stmt);

echo "<br><p>After deletion</p>";
$result = $con->query($sql);
echo "<br><table border=\"1\">";
echo "<tr><th>NAME</th><th>AGE</th><th>DATE</th><th>ADDRESS</th><th>PHONE</th><th>EMAIL</th></tr>";
if ($result->num_rows>0)
{
while ($row = $result->fetch_assoc())
	echo "<tr><td>".$row["name"]."</td><td>".$row["age"]."</td><td>".$row["dob"]."</td><td>".$row["addr"]."</td><td>".$row["mob"]."</td><td>".$row["email"]."</td></tr>";
}
echo "</table>";
}
?>
</html>