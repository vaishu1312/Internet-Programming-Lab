<%@ page errorPage="errorpage.jsp" %>

<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart" />
<html>
  <head>
    <style>

      body{
        background-color: #FFB6C1; 
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
    <title>Catalog of Items</title>
  </head>
  <body>
  <%
    String id = request.getParameter("id");
    if ( id != null ) {
      String type = request.getParameter("Submit");
      if(type!=null) {
      if (type.equals("  +  "))   {
      		String desc = request.getParameter("desc");
            Float price = new Float(request.getParameter("price"));
            Integer count = new Integer(request.getParameter("cnt"));

            cart.addItem(id, desc, price.floatValue(), count);
        }
        else if (type.equals("RemoveAll")) {
    		  cart.removeItem(id);
      }
       else if (type.equals("  -  ")) {
    		 String desc = request.getParameter("desc");
            Float price = new Float(request.getParameter("price"));

            cart.reduceqty(id, desc, price.floatValue(), 1);
      }
      }
  }
  %>

  <center style="font-size: 60px;">
    <strong>Shopping Mart </strong>
  </center>

  <a href="ShoppingCart.jsp">CART  :</a>
    <%=cart.getNumOfItems() %><p> Total   : Rs.<%=cart.getCost() %></p>

  <table style="width: 100%; height: 100%;" border="1" cellpadding="20" cellspacing="0" id="customers">
    <tr>
      <th>Products</th>
      <th>Preview</th>
      <th>Price</th>
      <th>Add/Remove</th>
    </tr>
    <tr>
      <form action="HomePage.jsp" method="post">
        <td align="center">One Plus 7 pro</td>
        <td align="center"><img src="phone.jpg" width="300" ;height="100"></td>
        <td align="center">Rs.55,000</td>
        <td align="center">
          <br /><select id="countvalue" name="cnt">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
          </select><input type="submit" name="Submit" value="  +  "><br />
          <input type="submit" name="Submit" value="  -  "><br />
          <input type="submit" name="Submit" value="RemoveAll"></td>
        <input type="hidden" name="id" value="1">
        <input type="hidden" name="desc" value="phone">
        <input type="hidden" name="price" value="55000">
      </form>
    </tr>
    <tr>
      <form action="HomePage.jsp" method="post">
        <td align="center">Smart watch</td>
        <td align="center"><img src="tv.jpg" width="300" ;height="100"></td>
        <td align="center">Rs.30,000</td>
        <td align="center"><br /><select id="countvalue" name="cnt">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
          </select><input type="submit" name="Submit" value="  +  ">
          <br><input type="submit" name="Submit" value="  -  ">
          <br><input type="submit" name="Submit" value="RemoveAll"></td>
        <input type="hidden" name="id" value="2">
        <input type="hidden" name="desc" value="Smart watch">
        <input type="hidden" name="price" value="30000">
      </form>
    </tr>
    <tr>
      <form action="HomePage.jsp" method="post">
        <td align="center">jbl earphones</td>
        <td align="center"><img src="ear.jpg" width="300" ;height="300"></td>
        <td align="center">Rs.1,600</td>
        <td align="center"><br /><select id="countvalue" name="cnt">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
          </select><input type="submit" name="Submit" value="  +  ">
          <br><input type="submit" name="Submit" value="  -  ">
          <br><input type="submit" name="Submit" value="RemoveAll">
          <input type="hidden" name="id" value="3">
          <input type="hidden" name="desc" value="earphones">
          <input type="hidden" name="price" value="1600">
      </form>
    </tr>
    <tr>
      <form action="HomePage.jsp" method="post">
        <td align="center">Spectacles</td>
        <td align="center"><img src="wei.jpg" width="300" ;height="100"></td>
        <td align="center">Rs.800</td>
        <td align="center"><br /><select id="countvalue" name="cnt">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
          </select><input type="submit" name="Submit" value="  +  ">
          <br><input type="submit" name="Submit" value="  -  ">
          <br><input type="submit" name="Submit" value="RemoveAll"></td>
        <input type="hidden" name="id" value="4">
        <input type="hidden" name="desc" value="Spectacles">
        <input type="hidden" name="price" value="800">
      </form>
    </tr>
  </table>
  </body>
</html>
