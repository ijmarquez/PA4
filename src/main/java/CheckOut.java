import model.Cart;

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
        int qty = 0;
        String item = "", size = "";
        NumberFormat moneyFormat = new DecimalFormat("#0.00");

        Cart currentItem = null;
        if(request.getParameter("quantity") != null) {
            qty = Integer.parseInt(request.getParameter("quantity"));
            item = request.getParameter("item");
            size = request.getParameter("size");
            currentItem = new Cart(item, qty, size, 10);
        }

        PrintWriter out = response.getWriter();

        if(currentItem!=null) {
            totalPreTax = 0;
            final String itemName = currentItem.getName();
            final int itemQty = currentItem.getQty();
            final String itemSize = currentItem.getSize();
            final double total = currentItem.getTotalCost();
            totalPreTax += total;
            //make API call here to store items to customer


            out.println("<tr>");
            out.println("<td><p> "+ 1 +".  <input type=\"text\" name=\"itemName\" value=\""+itemName+"\" class=\"inputReadOnly\" readonly></p></td>");
            out.println("</tr>");
            out.println("<td><p>Size: <input type=\"text\" name=\"itemSize\" value=\""+itemSize+"\" class=\"inputReadOnly\" readonly> </p></td>");
            out.println("<td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=\""+itemQty+"\" class=\"inputReadOnly\" readonly> </p></td>");
            out.println("<td><p>Total Cost: $<input name=\"unitPrice\" value=\""+moneyFormat.format(total)+"\" class=\"inputReadOnly\" readonly> </input></p></td>");
            out.println("</tr>");

        }
        out.println("</table>");
        out.println("<div class=\"centerOverview\">");
        out.println("<p>Total: $ <input input id=\"totalCost\" name=\"total\" value=\""+moneyFormat.format(totalPreTax)+"\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("</div>");
    }
}




