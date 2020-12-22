<%@ page errorPage="errorpage.jsp" %>
<%@ page import="java.util.*" %>

<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart" />
<html>
  <head>
    <style>

      body{
        background-color: #FFB6C1; 
        
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        font-size: 20px
      }


      #customers {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
      }

      #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
      }

      /*#customers tr:nth-child(even){background-color: #f2f2f2;}*/

      #customers tr:hover {background-color: #FF69B4;}

      #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: red;
        color: white;
      }
    </style>
    <title>Shopping Cart Contents</title>
  </head>
  <body>
    <center>
    <table width="70%" border="1" cellspacing="0"
      cellpadding="20" border="0" id="customers">
      <caption><b>Shopping Cart Contents</b></caption>
      <tr>
        <th>Description</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Subtotal</th>
      </tr>
    <%
      Enumeration e = cart.getEnumeration();
      String[] tmpItem;
      // Iterate over the cart
      while (e.hasMoreElements()) {
        tmpItem = (String[])e.nextElement();
        %>
        <tr>
          <td><%=tmpItem[1] %></td>
          <td align="center">Rs.<%=tmpItem[2] %></td>
          <td align="center"><%=tmpItem[3] %></td>
          <td align="center">Rs.<%=Float.parseFloat(tmpItem[2])*Float.parseFloat(tmpItem[3]) %> </td>
        </tr>



        <%
      }
    %>
    <tr>
      <td>Total</td>
      <td></td>
      <td align="center"><%=cart.getNumOfItems() %></td>
      <td align="center">Rs.<%=cart.getCost() %></td>
    </tr>
    </table>
    </center>
    <a href="HomePage.jsp">HomePage</a>
  </body>
</html>
