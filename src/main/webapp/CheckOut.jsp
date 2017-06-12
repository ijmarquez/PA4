<%--
  Created by IntelliJ IDEA.
  User: Calvin
  Date: 6/9/2017
  Time: 12:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/header_footer.css">
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <link rel="stylesheet" type="text/css" href="css/footerContent.css">
    <link rel="stylesheet" type="text/css" href="css/items_list.css">
    <link rel="stylesheet" type="text/css" href="css/items.css">
    <link rel="stylesheet" type="text/css" href="css/buyItem.css">
    <link rel="stylesheet" type="text/css" href="css/customerOrder.css">
    <script type="text/javascript" src="js/buyItem.js"></script>
    <script type="text/javascript" src="js/item.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-3-typeahead/4.0.1/bootstrap3-typeahead.min.js"></script>
</head>
<title> Clothing Couture </title>
<body>
<div class="pageContainer">
    <div class="homeContainer">
        <div class="home-logo">
            <h1>Clothing Couture</h1>
        </div>

        <div class="navMenu">
            <ul class="navBar">
                <li> <a class="userOption" href="home"> Welcome </a> </li>
                <li> <a class="userOption" href="itemsList.jsp"> Home </a> </li>
            </ul>
        </div>
    </div>

    <%--body--%>
    <div class="form">
        <form method="POST" action="http://andromeda-64.ics.uci.edu:5064/jerseyrest/v1/api/todos" name="userInfo" onsubmit="checkForm()">
            <div class="itemSelected">
                <h1> Customer Information </h1>
                <h2 class="formSep"> Order Summary </h2>
                <table class="shoppingCartTable">
                    <jsp:include page="/CheckOut"/>
            </div>

            <table class="buyItemTableContainer">
                <h2 class="formSep">Personal Information</h2>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName"></td>
                </tr>

                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName"></td>
                </tr>

                <tr>
                    <td> Email Address: </td>
                    <td> <input type="email" name="emailAddress"> </td>
                </tr>

                <tr>
                    <td> Phone Number: </td>
                    <td> <input type="tel" name="phoneArea"> - </td>
                    <td> <input type="tel" name="phoneThree"> - </td>
                    <td> <input type="tel" name="phoneFour"> </td>
                </tr>
            </table>

            <table class="buyItemTableContainer">
                <h2 class="formSep">Billing Information</h2>
                <tr>
                    <td>Credit Card Type:</td>
                    <td>
                        <select name="ccType">
                            <option value="Visa">Visa</option>
                            <option value="MasterCard">MasterCard</option>
                            <option value="AMEX">AMEX</option>
                            <option value="Discover">Discover</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td> Credit Card:</td>
                    <td><input type="text" name="creditCardNumber"> </td>
                </tr>

                <tr>
                    <td> Expiration Date:</td>
                    <td><input type="text" name="ccExpire"> </td>
                </tr>

                <tr>
                    <td>Billing Address: </td>
                    <td> <input type="text" name="billAddress"> </td>
                </tr>

                <tr>
                    <td>City: </td>
                    <td> <input type="text" name="billCity" id="billCity" class="city"> </td>
                </tr>

                <tr>
                    <td>State: </td>
                    <td> <input type="text" name="billState" id="billState"> </td>
                </tr>

                <tr>
                    <td>Zip Code: </td>
                    <td> <input type="text" name="billZipCode" > </td>
                </tr>
            </table>

            <table class="buyItemTableContainer">
                <h2 class="formSep"> Shipping Information</h2>
                <tr>
                    <td>Shipping Address: </td>
                    <td> <input type="text" name="shipAddress"></td>
                </tr>

                <tr>
                    <td>City: </td>
                    <td> <input type="text" name="shipCity" id="shipCity" class="city"> </td>
                </tr>

                <tr>
                    <td>State: </td>
                    <td> <input type="text" name="shipState" id="shipState"> </td>
                </tr>

                <tr>
                    <td>Zip Code: </td>
                    <td> <input type="text" name="shipZipCode" > </td>
                </tr>

                <tr>
                </tr>
            </table>

            <div class="costContainer">
                <div id="submitOrder">
                    <input id="btn" type="submit" value="Submit Order" onclick="return checkForm(); return false">
                </div>
            </div>
        </form>
    </div>


    <footer>
        <div class="footer">
            <a class="footerOption" href="about.php">about us</a>
            <a class="footerOption" href="contact.php">contact us</a>
        </div>
    </footer>
</div>
</body>
</html>