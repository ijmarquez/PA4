import model.Cart;

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
public class OrderDetails extends HttpServlet {

    private ArrayList<Cart> itemList = new ArrayList<Cart>();
    private double totalCost = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        NumberFormat moneyFormat = new DecimalFormat("#0.00");

        // get customer data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        String phoneArea = request.getParameter("phoneArea");
        String phoneThree = request.getParameter("phoneThree");
        String phoneFour = request.getParameter("phoneFour");
        String phoneNumber = phoneArea.concat(phoneThree).concat(phoneFour);

        String ccType = request.getParameter("ccType");

        String billAddress = request.getParameter("billAddress");
        String billCity = request.getParameter("billCity");
        String billState = request.getParameter("billState");
        int    billZipCode = Integer.parseInt(request.getParameter("billZipCode"));

        String shipAddress = request.getParameter("shipAddress");
        String shipCity = request.getParameter("shipCity");
        String shipState = request.getParameter("shipState");
        int    shipZipCode = Integer.parseInt(request.getParameter("shipZipCode"));
        String deliveryType = request.getParameter("deliveryType");

        String itemName = request.getParameter("itemName");
        String itemSize = request.getParameter("itemSize");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
        double totalCost = Double.parseDouble(request.getParameter("total"));

        PrintWriter out = response.getWriter();

        //header
        Constants.header(out);

        //body
        out.println("<div class=\"confirmContainer\">");
        out.println("<h2> Order Complete </h2>");
        out.println("<h3> Order Summary</h3>");

        /* dateplaced, ordernumber, ordertotal,
        items ordered: quantity, productname
        shipping address: fname, lname, street, city, state, zip, country, shipping method
        payment method, billing address, total
        */

        out.println("<div>");
        out.println("<table class=\"shoppingCartTable\">");

        //dynamically add here
        HttpSession session = request.getSession();
//        itemList = (ArrayList<Cart>) session.getAttribute("shoppingCart");
//        if(itemList == null) {
//            itemList = new ArrayList<Cart>();
//        }
//
//        if(itemList!=null || itemList.size() != 0) {
//            totalCost = 0;
//            for (int i =0 ; i < itemList.size(); ++i) {
//                Cart itemPick = itemList.get(i);
//                final String itemName = itemPick.getName();
//                final int itemQty = itemPick.getQty();
//                final String itemSize = itemPick.getSize();
//                final int total = (itemQty * 10);
//                itemList.get(i).setTotalCost(total);
//                totalCost += total;
                out.println("<tr>");
                out.println("<td><p> "+1+". "+itemName+"</p></td>");
                out.println("</tr>");
                out.println("<td><p>Size: "+itemSize+"</p> </td>");
                out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=\""+quantity+"\" class=\"inputReadOnly\" readonly> </p></td>");
                out.println("<td><p>Total Cost: $<input name=\"unitPrice\" value=\""+moneyFormat.format(unitPrice)+"\" class=\"inputReadOnly\" readonly> </input></p></td>");
                out.println("</tr>");
//            }
//        }

        itemList = new ArrayList<Cart>();
        session.setAttribute("shoppingCart", itemList);
        //end of each item
        out.println("</table>");
        out.println("</div>");

        out.println("<br>");
        out.println("<div class=\"centerOverview\">");
        out.println("<p>Total: $ <input input id=\"totalCost\" name=\"total\" value=\""+moneyFormat.format(totalCost)+"\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("</div>");

//        out.println("<p>OrderId: " + orderId + "</p>");
        out.println("<h3>Personal Information: </h3>");
        out.println("<p> Name: " + firstName +" "+ lastName + "</p>");
        out.println("<p> Email Address: " + emailAddress + "</p>");
        out.println("<p> Phone Number: " + phoneNumber +"</p>");

        out.println("<h3>Billing Information: </h3>");
        out.println("<p> Credit Card: " + ccType + "<br>");
        out.println("Billing Address: <br>" + billAddress + "<br>" + billCity + ", " + billState+ " " + billZipCode +"</p>");

        out.println("<h3>Shipping Information: </h3>");
        out.println("<p> Shipping Address: <br>" + shipAddress + "<br>" + shipCity + ", " + shipState+ " " + shipZipCode +"</p>");

        out.println("</div>");
        out.println("<div id=\"submitOrder\">");
        out.println("<input id=\"btn\" type=\"submit\" value=\"Finish\" onclick=\"location.href='home'\"></div>");

        //footer
        Constants.footer(out);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}



