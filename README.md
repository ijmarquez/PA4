Project Title 
PA 3: Building a web application using Java Servlets


Group Members: Marquez, Irish and Poon, Calvin


URL
http://andromeda-64.ics.uci.edu:5064/pa3/home


HOMEPAGE

ItemsList servlet - handles displaying of the products obtained from the database. Uses RequestDispatcher “include” feature at the bottom of the code.

PreviousItemsViewed servlet - uses session tracking to display products visited. It displays up to 5 items recently viewed by the user. Clicking on any item takes the user to Item page.



PRODUCT DETAILS

Item servlet – displays the item. Uses request.getParameter() command to get details about the item and queries the database to be able to display the item. Uses session to add item into the shopping cart. Choosing a size and color and clicking “Add to cart” button adds the item onto the shopping cart and then takes user to the Shopping cart page.

ShoppingCart servlet – displays the item name, item size, item quantity, cost of each item, and total. Clicking Checkout button takes the user to the CheckOut (Customer Information) page.


CHECK OUT

CheckOut servlet contains:

Items – shown on top of the page are all the products in the shopping cart.

Form – has personal information, billing information, and shipping information where user can enter relevant user info such as name, address, phone number, etc.

Total – located at the bottom of the page.

Submit Order button – located at the bottom of the page. When the user clicks the button, user is taken to Order Complete page.


StoreOrderInDB servlet – in the backend, user is taken from CheckOut to StoreOrderInDB to OrderDetails.

StoreOrderInDB servlet connects to the db.

StoreOrderInDB servlet retrieves data from HttpServletRequest, passes them into db and forwards control (using RequestDispatcher “forward” feature) to OrderDetails servlet.

OrderDetails servlet – displays order summary along with the user’s personal, billing, and shipping information. Clicking the Finish button takes the user back to Home. Doing so clears the items previously stored in the shopping cart, clearing the previous session.
