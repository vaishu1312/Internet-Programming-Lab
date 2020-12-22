#README

This is an online shopping cart applicationwhich uses javascript, sessions and javabeans.

1) HomePage.jsp

	This file contains the list of items for sale.
	It has internal css style.
	Javascript is used alongside html tags to add and remove the selected items to the cart.

	The script uses:

		1. getParameter()- to obtain input from user.
		2. addItem()- to add items to the cart.
		3. removeItem()- to remove items from cart.
		4. reduceItem()- to reduce the quantity of the item by 1.

	Some of the HTML 5 tags used are:
		1. <form>
		2. <table>
		3. <input>
		4. <option>


2) ShoppingCart.jsp

	This file contains the list of items present in the cart along with the subcost of each type of item and the total cost.
	It stores the input from HomePage.jsp in a beans file.
	The items are stored as an enumeration using gatEnumeration() and the subcost and cost is displayed using parseFloat().

	The HTML tags display the number of items using getNumberOfItems() and cost using getCost().

3) ShoppingCart.java

	It contains the following functions:

		1. addItem()
		2. reduceItem()
		3. removeItem()
		4. updateQuantity()
		5. getEnumeration()
		6. getCost()
		7. getNumberOfItems()

	These funcions are used in HomePage.jsp and ShoppingCart.jsp.



