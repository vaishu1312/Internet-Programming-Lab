function checkName(id)
{
 
  var input= document.getElementById(id).value;
  if(input==="")
  {
     window.alert("Name is a required field");
  }
  else
   { 
	var v1 = new RegExp("^[a-zA-Z]*$");
	if(!v1.test(input))
    		window.alert(input+" is not a valid name");
   }
}

function checkGender(id)
{
    var x= document.getElementById(id)
    if(x.checked === true)
        window.alert("Gender is "+x.value);
}

function checkDob(id)
{
var days_of_mon;
var date=document.getElementById(id).value;
if ( date =="")
{	window.alert("DOB is a required field");
  return;
}
date=date.split("-");
var day=date[0];
var month=date[1];
var year= date[2];

//window.alert("dob: "+day+month+year);

var dTest = RegExp("^\\d{4}$");
if (year=="" || !dTest.test(year) || year>2020)
	window.alert(year+" is an invalid year");
else  //yr is valid
{
   if ( month=="" || month<1 || month>12)
    	window.alert(month+" is not an valid month");
   else  //yr, mon is valid 
   {
     if (day==""  ||  day<1 || day>31 )
	       window.alert(day+" is not an valid day");
     else 
     {	
	year=parseInt(year);
	//window.alert("type"+typeof year);
	
      if(year%4==0)
	{     days_of_mon=[31,28,31,30,31,30,31,31,30,31,30,31];		}
       else
       { days_of_mon=[31,29,31,30,31,30,31,31,30,31,30,31];   	}
	  var idx=month-1;
	  if (day>days_of_mon[idx])
		      window.alert("The DOB is invalid!");
	  else 
		      window.alert("Date is "+day+"-"+month+"-"+year);
      }
 
   }
}

}

function checkAdd(id)
{
 
  var input= document.getElementById(id).value;
  if(input==="")
     window.alert("Address is a required field");
  else 
	window.alert("Your address is: "+input);
}

function checkNo(id)
{
  var input= document.getElementById(id).value;
  if(input==="")
  {
     window.alert("Mobile No is a required field");
  }
  else
   { 
	var v1 = new RegExp("^\\d{10}$");
	if(!v1.test(input))
    		window.alert(input+" is not a valid no");
   }
}

function checkEmail(id)
{
 
  var input= document.getElementById(id).value;
  if(input==="")
  {
     window.alert("Email is a required field");
  }
 else
{
  var v2=new RegExp("^(\\w|\\d)*@\\w*.com$");
  if(!v2.test(input))
	window.alert(input+" is not a valid email-id");
}
}

function display()
{
var str="";
var n = document.getElementById("nameid").value;
str+="NAME : "+n+"\n";

var g = document.getElementById("i2");
if (g.checked)
str+="GENDER: "+g.value+"\n";

var g = document.getElementById("i3");
if (g.checked)
str+="GENDER: "+g.value+"\n";

var g = document.getElementById("i4");
if (g.checked)
str+="GENDER: "+g.value+"\n";

var date=document.getElementById("idate").value;
str+="DOB: "+date+"\n";

str+="ADDRESS : "+document.getElementById("addid").value+"\n";

var m = document.getElementById("mobid").value;
str+="MOBILE NUMBER : "+m+"\n";

var m = document.getElementById("emailid").value;
str+="EMAIL ID : "+m+"\n";

var g = document.getElementById("c1");
if (g.checked)
str+="EDUCATION :"+g.value+"\n";

var g = document.getElementById("c2");
if (g.checked)
str+="                 "+g.value+"\n";

var g = document.getElementById("c3");
if (g.checked)
str+="                 "+g.value+"\n";


window.alert("***********************DETAILS*************************\n"+str);
}