<html>

<?php

$regexName = '/^[A-Za-z]+$/';
$regexAge = '/^[0-9]{2}$/';
$regexNum = '/^[0-9]{10}$/';
$regexMail = '/^[a-zA-Z][a-zA-Z0-9]+\@[a-z]+\.[a-z]+$/';

$flag=0;

$name=$_GET["t1"];
$age=$_GET["t2"];
$dob=$_GET["t3"];
$addr=$_GET["t4"];
$mob=$_GET["t5"];
$email=$_GET["t6"];

	if(preg_match($regexName, $name)) {
		if(preg_match($regexAge, $age)) {
			if(preg_match($regexNum, $mob)) {
				if(preg_match($regexMail, $email)) {
					$flag=1;
				}
				else {
					echo "Invalid e-mail id";
				}
			}
			else {
				echo "Invalid phone number";		
			}
		}
		else {
			echo "Invalid age";
		}
	} 
	else { 
    		echo "Invalid name";  
	}

	echo "<br><br>";

if($flag==1)
{
$con=new mysqli("localhost:3306","root","","test");
if($con->connect_error)
    echo "Falied";
else
{     

$sql = "select * from stud";
$result = $con->query($sql);
echo "<br><p>Before insertion</p>";
echo "<br><table border=\"1\">";
echo "<tr><th>NAME</th><th>AGE</th><th>DATE</th><th>ADDRESS</th><th>PHONE</th><th>EMAIL</th></tr>";
if ($result->num_rows>0)
{
while ($row = $result->fetch_assoc())
	echo "<tr><td>".$row["name"]."</td><td>".$row["age"]."</td><td>".$row["dob"]."</td><td>".$row["addr"]."</td><td>".$row["mob"]."</td><td>".$row["email"]."</td></tr>";
}
echo "</table>";

$ins = "insert into stud values(?,?,?,?,?,?)";
$stmt=mysqli_prepare($con,$ins);
mysqli_stmt_bind_param($stmt,"ssssss",$name,$age,$dob,$addr,$mob,$email);

mysqli_stmt_execute($stmt);

echo "<br><p>After insertion</p>";
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
}
?>
</html>