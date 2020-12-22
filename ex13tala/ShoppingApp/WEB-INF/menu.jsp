<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="Bean.ItemBean" %>
<html>
<body>
<h1>PRODUCTS</h1><br><br>
<%
int i;
String name[] = new String[5];
String price[] = new String[5];
ItemBean pbean=(ItemBean) session.getAttribute("pbean");

Cookie cookie = null;
Cookie[] cookies = null;
cookies = request.getCookies();
cookie=cookies[0];

String user=cookie.getName();
String userv=cookie.getValue();
for(i=0;i<4;i++)
{
name[i]=pbean.getname(i);
price[i]=pbean.getprice(i);
}
pageContext.setAttribute("prod_names",name);
pageContext.setAttribute("prod_prices",price);
pageContext.setAttribute("user",user);
pageContext.setAttribute("userv",userv);
%>

<c:forEach var="i" begin="0" end="3">
<form method="post" action="cartcontrol">
<c:out value="Biscuit: ${prod_names[i]}"/><br>
<c:out value="Cost: ${prod_prices[i]}"/><br>
<input type="number" name="${i}_quant" min="0"><br>
<input type="submit" name="${i}_button" value="+"><br>
<input type="submit" name="${i}_button" value="-"><br>
</form></c:forEach>
<form method="get" action="cartcontents">
<input type="submit" name="viewcart" value="Go to My Cart"><br>
</form>
</body>
</html>
