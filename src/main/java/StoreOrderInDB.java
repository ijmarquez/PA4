import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by irishmarquez on 5/29/17.
 */
@WebServlet(name = "StoreOrderInDB")
public class StoreOrderInDB extends HttpServlet {
    private ArrayList<Cart> itemList = new ArrayList<Cart>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        itemList = (ArrayList<Cart>) session.getAttribute("shoppingCart");
        if(itemList == null) {
            itemList = new ArrayList<Cart>();
        }

        //connect to the DB information
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = Constants.getDatabaseName();
        final String DB_USER = Constants.getUsername();
        final String DB_PASS = Constants.getPassword();
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        out.println("<p>Small steps</p>");
        //insert each item in a loop here
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            out.println("<p>May</p>");
            // get customer data
            int    customerId = 0;  // 0 so compiler doesn't complain About initializing

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");

            String phoneArea = request.getParameter("phoneArea");
            String phoneThree = request.getParameter("phoneThree");
            String phoneFour = request.getParameter("phoneFour");
            String phoneNumber = phoneArea.concat(phoneThree).concat(phoneFour);

            String ccType = request.getParameter("ccType");
            String creditCardNumber = request.getParameter("creditCardNumber");
            String ccExpire = request.getParameter("ccExpire");

            String billAddress = request.getParameter("billAddress");
            String billCity = request.getParameter("billCity");
            String billState = request.getParameter("billState");
            int    billZipCode = Integer.parseInt(request.getParameter("billZipCode"));

            String shipAddress = request.getParameter("shipAddress");
            String shipCity = request.getParameter("shipCity");
            String shipState = request.getParameter("shipState");
            int    shipZipCode = Integer.parseInt(request.getParameter("shipZipCode"));
            String deliveryType = request.getParameter("deliveryType");

            out.println("<p> TESTING </p>");
            out.println("<p> FIRST NAME: "+ firstName +"</p>");
            out.println("<p> LAST NAME: "+ lastName +"</p>");
            out.println("<p> EMAIL ADDRESS: "+ emailAddress +"</p>");
            out.println("<p> PHONE NUMBER: "+ phoneNumber +"</p>");

            out.println("<p> CC TYPE: "+ ccType +"</p>");
            out.println("<p> CC NUMBER:" + creditCardNumber +"</p>");
            out.println("<p> CC EXPIRE: "+ ccExpire +"</p>");

            out.println("<p> BILL ADDRESS: "+ billAddress +"</p>");
            out.println("<p> BILL City: "+ billCity +"</p>");
            out.println("<p> BILL State: "+ billState +"</p>");
            out.println("<p> BILL Zip Code: "+ billZipCode +"</p>");

            out.println("<p> SHIP ADDRESS: "+ shipAddress +"</p>");
            out.println("<p> SHIP CITY: "+ shipCity +"</p>");
            out.println("<p> SHIP STATE: "+ shipState +"</p>");
            out.println("<p> SHIP ZIP CODE: "+ shipZipCode +"</p>");
            out.println("<p> DELIVERY TYPE: "+ deliveryType +"</p>");

            double totalAmount = 0;
            //add items to orderDetail table in DB
            if(itemList!=null || itemList.size() != 0) {
                totalAmount = 0;
                for (int i =0 ; i < itemList.size(); ++i) {
                    Cart itemPick = itemList.get(i);
                    final String itemName = itemPick.getName();
                    final int itemQty = itemPick.getQty();
                    final String itemSize = itemPick.getSize();
                    final double total = itemList.get(i).getTotalCost();
                    totalAmount += total;
                    sql = "INSERT INTO OrderDetails (orderId, productId, itemSize, unitPrice, quantity, total) " +
                            "VALUES(\""+(firstName+lastName)+"\",\""+itemName+"\",\""+itemSize+"\", 10,\""+itemQty+"\",\""+total+"\")";
                    stmt.executeUpdate(sql);
                }
            }

            //stores customer information into database
            sql = "INSERT INTO Customer (firstName, lastName, emailAddress, phoneNumber, ccType, creditCardNumber,ccExpire, billAddress, billCity, billState, billZipCode, shipAddress, shipCity, shipState, shipZipCode, deliveryType, itemPurchase, total) " +
                    "VALUES(\""+firstName+"\",\""+lastName+"\",\""+emailAddress+"\",\""+phoneNumber+"\",\""+ccType+"\",\""+creditCardNumber+"\",\""+ccExpire+"\",\""+billAddress+"\",\""+billCity+"\",\""
                    +billState+"\","+billZipCode+",\""+shipAddress+"\",\""+shipCity+"\",\""+shipState+"\","+shipZipCode+",\""+deliveryType+"\",\""+(firstName+lastName)+"\","+totalAmount+")";
            stmt.executeUpdate(sql);

            // Previously-viewed items, param is the servlet name
            RequestDispatcher rd = request.getRequestDispatcher("OrderDetails");
            rd.forward(request, response);
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
        out.println("<p>Great successes</p>");
    }

}