<%@ page errorPage="errorpage.jsp" %>

<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart" />
<html>
  <head>
    <title>Online Shopping</title>
  </head>
  <body>
  <% 
    String id = request.getParameter("id");
    if ( id != null ) {
      String type = request.getParameter("Submit");
      if(type!=null) {
      if (type.equals("Add"))   {
      	    String desc = request.getParameter("desc");
            Float price = new Float(request.getParameter("price"));
  
            cart.addItem(id, desc, price.floatValue(), 1);
        }
        else if (type.equals("RemoveAll")) {
    		  cart.removeItem(id);
      }
       else if (type.equals("Remove")) {
    		 String desc = request.getParameter("desc");
            Float price = new Float(request.getParameter("price"));
            
            cart.reduceqty(id, desc, price.floatValue(), 1);
      }
      }
  }
  %>
 
  <a href="ShoppingCart.jsp">Shopping Cart Total Quantity:</a>
    <%=cart.getNumOfItems() %><p> Total Estimated Price: $<%=cart.getCost() %></p>
  
  <center><h3>welcome</h3></center>
  <table align="center">
    <tr><th>Description</th><th>Image</th><th>Price</th><th>Add/Remove</th></tr>
    <tr>
      <form action="AddToShoppingCart.jsp" method="post">
        <td>Samsung S 10</td>
        <td><img src="phone.jpg" width="300";height="100"></td>
        <td>$599.95</td>
        <td align="center"><input type="submit" name="Submit" value="Add"><br>
        <br><input type="submit" name="Submit" value="Remove"><br>
        <br><input type="submit" name="Submit" value="RemoveAll"></td>
        <input type="hidden" name="id" value="1">
        <input type="hidden" name="desc" value="phone">
        <input type="hidden" name="price" value="599.95">
      </form>
    </tr>
    <tr>
      <form action="AddToShoppingCart.jsp" method="post">
        <td>Android Smart TV</td>
        <td><img src="tv.jpg" width="300";height="100"></td>
        <td>$399</td>
        <td align="center"><input type="submit" name="Submit" value="Add"><br>
        <br><input type="submit" name="Submit" value="Remove"><br>
        <br><input type="submit" name="Submit" value="RemoveAll"></td>
        <input type="hidden" name="id" value="2">
        <input type="hidden" name="desc" value="Smart TV">
        <input type="hidden" name="price" value="399">
      </form>
    </tr>
    <tr>
      <form action="AddToShoppingCart.jsp" method="post">
        <td>Sony Headphones</td>
        <td><img src="headphones.jpg" width="300";height="300"></td>
        <td>$300</td>
        <td align="center"><input type="submit" name="Submit" value="Add"><br>        
        <br><input type="submit" name="Submit" value="Remove"><br>
        <br><input type="submit" name="Submit" value="RemoveAll">
        <input type="hidden" name="id" value="3">
        <input type="hidden" name="desc" value="Headphones"> 
        <input type="hidden" name="price" value="300">
      </form>
    </tr>
    <tr>
      <form action="AddToShoppingCart.jsp" method="post">
        <td>Weighing Scale</td>
        <td><img src="weights.jpg" width="300";height="100"></td>
        <td>$15.95</td>
        <td align="center"><input type="submit" name="Submit" value="Add"><br>        
        <br><input type="submit" name="Submit" value="Remove"><br>
        <br><input type="submit" name="Submit" value="RemoveAll"></td>
        <input type="hidden" name="id" value="4">
        <input type="hidden" name="desc" value="scale">
        <input type="hidden" name="price" value="15.95">
      </form>
    </tr>

    </table>
  </body>
</html>