<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>");
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
                <li> <a class="userOption" href="itemsList"> Home </a> </li>
                <li> <a class="userOption" href="ShoppingCart"> Shopping Cart </a> </li>
            </ul>
        </div>
    </div>

    <!-- start here -->
    <div class="items-container">
        <div class="items-contents">
            <!-- get items here -->

            <%
                //connect to the DB information
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                final String DB_URL = "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu/inf124-db-063";
                final String DB_USER = "inf124-db-063";
                final String DB_PASS = "GSaxgpMPZKhN";
                Connection conn = null;
                Statement stmt = null;

                //this is where it'll show the list of different items
                out.println("<div class=\"items-container\">");
                out.println("<div class=\"items-contents\">");
                out.println("<table class=\"itemListTable\">");

                //insert each item in a loop here
                //REPLACE THIS WITH REST CALL WHEN IMPLEMENTED
                try
                {
                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

                    stmt = conn.createStatement();
                    String sql = "SELECT * FROM MainProduct";
                    ResultSet rs = stmt.executeQuery(sql);
                    int i = 1;
                    while (rs.next())
                    {
                        if ( i == 1) {
                            out.println("<tr>");
                        }
                        if(i == 5) {
                            out.println("</tr>");
                            i = 1;
                        }
                        out.println("<td>");

                        String generalName = rs.getString("generalName");
                        String imageLocation = rs.getString("imageLocation");
                        String cost = rs.getString("cost");

                        out.println("<div class='image_thumbnail_holder'>");
                        out.println("<a href=\"Item?product='"+generalName+"'&amp;image='"+imageLocation+"'\">");
                        out.println("<img class=\"image_thumbnail\" src= \""+ imageLocation +"\" alt= \""+ generalName+"\" onclick=\"ItemService\">");
                        out.println("</a></div>");

                        //display item name
                        out.println("<div class='items-name'><p>");
                        out.println(generalName);
                        out.println("</p></div>");

                        //display item prices
                        out.println("<div class='items-price'><p>");
                        out.println(cost);
                        out.println("</p></div>");

                        //end of column
                        out.println("</td>");
                        i++;
                    }
                    stmt.close();
                    conn.close();
                }
                catch (ClassNotFoundException e)
                {
                    out.println("<p> CLASS NOT FOUND </p>");
                    e.printStackTrace();
                }
                catch (SQLException se)
                {
                    out.println(se);
                    se.printStackTrace();
                }

                out.println("</table>");
                out.println("</div>");
            %>
        </div>
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

