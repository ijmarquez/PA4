import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by Calvin on 5/24/2017.
 */
public class CheckOut extends HttpServlet {
    private ArrayList<Cart> itemList = new ArrayList<Cart>();
    private double totalPreTax = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NumberFormat moneyFormat = new DecimalFormat("#0.00");
        HttpSession session = request.getSession();
        itemList = (ArrayList<Cart>) session.getAttribute("shoppingCart");
        if(itemList == null) {
            itemList = new ArrayList<Cart>();
        }

        PrintWriter out = response.getWriter();

        //header
//        Constants.header(out);

//        //body
//        out.println("<div class=\"form\">");
//        out.println("<form method=\"POST\" action=\"http://andromeda-74.ics.uci.edu:23456/jerseyrest/v1/api/todos\" name=\"userInfo\" onsubmit=\"checkForm()\">");
//        out.println("<div class=\"itemSelected\">");
//        out.println("<h1> Customer Information </h1>");
////        out.println("<hr>");
//        out.println("<h2 class='formSep'> Order Summary </h2>");
//        out.println("<table class=\"shoppingCartTable\">");
        if(itemList!=null || itemList.size() != 0) {
            totalPreTax = 0;
            for (int i =0 ; i < itemList.size(); ++i) {
                Cart itemPick = itemList.get(i);
                final String itemName = itemPick.getName();
                final int itemQty = itemPick.getQty();
                final String itemSize = itemPick.getSize();
                final double total = itemList.get(i).getTotalCost();
                totalPreTax += total;
                //make API call here to store items to customer


                out.println("<tr>");
                out.println("<td><p> "+(i+1)+". "+itemName+"</p></td>");
                out.println("</tr>");
                out.println("<td><p>Size: "+itemSize+"</p> </td>");
                out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=\""+itemQty+"\" class=\"inputReadOnly\" readonly> </p></td>");
                out.println("<td><p>Total Cost: $<input name=\"unitPrice\" value=\""+moneyFormat.format(total)+"\" class=\"inputReadOnly\" readonly> </input></p></td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        out.println("<div class=\"centerOverview\">");
        out.println("<p>Total: $ <input input id=\"totalCost\" name=\"total\" value=\""+moneyFormat.format(totalPreTax)+"\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("</div>");
//        out.println("</div>");
//        out.println("<table class=\"buyItemTableContainer\">");
//        out.println("<h2 class=\"formSep\">Personal Information</h2>");
//        out.println("<tr>");
//        out.println("<td>First Name:</td>");
//        out.println("<td><input type=\"text\" name=\"firstName\"></td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>Last Name:</td>");
//        out.println("<td><input type=\"text\" name=\"lastName\"></td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td> Email Address: </td>");
//        out.println("<td> <input type=\"email\" name=\"emailAddress\"> </td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td> Phone Number: </td>");
//        out.println("<td> <input type=\"tel\" name=\"phoneArea\"> - </td>");
//        out.println("<td> <input type=\"tel\" name=\"phoneThree\"> - </td>");
//        out.println("<td> <input type=\"tel\" name=\"phoneFour\"> </td>");
//        out.println("</tr>");
//        out.println("</table>");
//        out.println("<table class=\"buyItemTableContainer\">");
//        out.println("<h2 class=\"formSep\">Billing Information</h2>");
//        out.println("<tr>");
//        out.println("<td>Credit Card Type:</td>");
//        out.println("<td>");
//        out.println("<select name=\"ccType\">");
//        out.println("<option value=\"Visa\">Visa</option>");
//        out.println("<option value=\"MasterCard\">MasterCard</option>");
//        out.println("<option value=\"AMEX\">AMEX</option>");
//        out.println("<option value=\"Discover\">Discover</option>");
//        out.println("</select>");
//        out.println("</td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td> Credit Card:</td>");
//        out.println("<td><input type=\"text\" name=\"creditCardNumber\"> </td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td> Expiration Date:</td>\n");
//        out.println("<td><input type=\"text\" name=\"ccExpire\"> </td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>Billing Address: </td>");
//        out.println("<td> <input type=\"text\" name=\"billAddress\"> </td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>City: </td>");
//        out.println("<td>");
//        out.println("<input type=\"text\" name=\"billCity\" id=\"billCity\" class=\"city\">");
//        out.println("</td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>State: </td>");
//        out.println("<td> <input type=\"text\" name=\"billState\" id=\"billState\"> </td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>Zip Code: </td>");
//        out.println("<td> <input type=\"text\" name=\"billZipCode\" > </td>");
//        out.println("</tr>");
//        out.println("</table>");
//        out.println("<table class=\"buyItemTableContainer\">");
//        out.println("<h2 class=\"formSep\"> Shipping Information</h2>");
//        out.println("<tr>");
//        out.println("<td>Shipping Address: </td>");
//        out.println("<td> <input type=\"text\" name=\"shipAddress\"></td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>City: </td>");
//        out.println("<td>");
//        out.println("<input type=\"text\" name=\"shipCity\" id=\"shipCity\" class=\"city\">");
//        out.println("</td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>State: </td>");
//        out.println("<td> <input type=\"text\" name=\"shipState\" id=\"shipState\"> </td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td>Zip Code: </td>");
//        out.println("<td> <input type=\"text\" name=\"shipZipCode\" > </td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("</tr>");
//        out.println("</table>");
//        out.println("<div class=\"costContainer\">");
//        out.println("<div id=\"submitOrder\">");
//        out.println("<input id=\"btn\" type=\"submit\" value=\"Submit Order\" onclick=\"return checkForm(); return false\">");
//        out.println("</div>");
//        out.println("</div>");
//        out.println("</form>");
//        out.println("</div>");
//
//        //footer
//        Constants.footer(out);
    }

}




