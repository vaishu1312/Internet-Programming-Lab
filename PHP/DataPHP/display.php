<html>
<?php
$con=new mysqli("localhost:3306","root","","test");
if($con->connect_error)
    echo "Falied";
else
{     

$sql = "select * from stud";
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