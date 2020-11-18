<%@ page import="Bean.questionbean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<body>
<%
int i,j;
String q[]=new String[4];
String ch1[]=new String[4];
String ch2[]=new String[4];
String ch3[]=new String[4];
String ch4[]=new String[4];
questionbean qbean=(questionbean)session.getAttribute("qbean");
for(i=0;i<4;i++)
{
q[i]=qbean.getQ(i);
ch1[i]=qbean.getCh1(i);
ch2[i]=qbean.getCh2(i);
ch3[i]=qbean.getCh3(i);
ch4[i]=qbean.getCh4(i);
}
session.setAttribute("q",q);
session.setAttribute("ch1",ch1);
session.setAttribute("ch2",ch2);
session.setAttribute("ch3",ch3);
session.setAttribute("ch4",ch4);
%>
<form method="post" action="anscontrol">
<c:forEach var="i" begin="0" end="3">
   <c:out value="${q[i]}"/><br>
   <input type="radio" name="${i}" value="a">
   <c:out value="${ch1[i]}"/>
   <input type="radio" name="${i}" value="b">
   <c:out value="${ch2[i]}"/>
   <input type="radio" name="${i}" value="c">
   <c:out value="${ch3[i]}"/>
   <input type="radio" name="${i}" value="d">
   <c:out value="${ch4[i]}"/><br><br>
</c:forEach>
<input type="submit" value="End quiz">
</form>

</body>
</html>
