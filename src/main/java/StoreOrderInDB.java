import model.Customer;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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
        //Setup to call Jersey API
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(Constants.getBaseURI());
        String jsonResponse =
                target.path("v1").path("api").path("todos").
                        request(). //send a request
                        accept(MediaType.APPLICATION_JSON). //specify the media type of the response
                        get(String.class); // use the get method and return the response as a string

        System.out.println(jsonResponse);
        ObjectMapper objectMapper = new ObjectMapper(); // This object is from the jackson library
        //insert each item in a loop here

        Customer customer = objectMapper.readValue(jsonResponse, Customer.class);

        // get customer data
        int customerId = 0;  // 0 so compiler doesn't complain About initializing
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setEmailAddress(request.getParameter("emailAddress"));

        String phoneArea = request.getParameter("phoneArea");
        String phoneThree = request.getParameter("phoneThree");
        String phoneFour = request.getParameter("phoneFour");
        customer.setPhoneNumber(phoneArea.concat(phoneThree).concat(phoneFour));

        customer.setCcType(request.getParameter("ccType"));
        customer.setCcNumber(request.getParameter("creditCardNumber"));
        customer.setCcExpire(request.getParameter("ccExpire"));

        customer.setBillAddress(request.getParameter("billAddress"));
        customer.setBillCity(request.getParameter("billCity"));
        customer.setBillState(request.getParameter("billState"));
        customer.setBillZipCode(Integer.parseInt(request.getParameter("billZipCode")));

        customer.setShipAddress(request.getParameter("shipAddress"));
        customer.setShipCity(request.getParameter("shipCity"));
        customer.setShipState(request.getParameter("shipState"));
        customer.setShipZipCode(Integer.parseInt(request.getParameter("shipZipCode")));
//        String deliveryType = request.getParameter("deliveryType"));

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

                //CALL API TO STORE ITEM TO DB
//                sql = "INSERT INTO OrderDetails (orderId, productId, itemSize, unitPrice, quantity, total) " +
//                        "VALUES(\""+(firstName+lastName)+"\",\""+itemName+"\",\""+itemSize+"\", 10,\""+itemQty+"\",\""+total+"\")";
//                stmt.executeUpdate(sql);
            }
        }

        //stores customer information into database
//        sql = "INSERT INTO Customer (firstName, lastName, emailAddress, phoneNumber, ccType, creditCardNumber,ccExpire, billAddress, billCity, billState, billZipCode, shipAddress, shipCity, shipState, shipZipCode, deliveryType, itemPurchase, total) " +
//                "VALUES(\""+firstName+"\",\""+lastName+"\",\""+emailAddress+"\",\""+phoneNumber+"\",\""+ccType+"\",\""+creditCardNumber+"\",\""+ccExpire+"\",\""+billAddress+"\",\""+billCity+"\",\""
//                +billState+"\","+billZipCode+",\""+shipAddress+"\",\""+shipCity+"\",\""+shipState+"\","+shipZipCode+",\""+deliveryType+"\",\""+(firstName+lastName)+"\","+totalAmount+")";
//        stmt.executeUpdate(sql);

        // Previously-viewed items, param is the servlet name
        RequestDispatcher rd = request.getRequestDispatcher("OrderDetails");
        rd.forward(request, response);
        out.println("<p>Great successes</p>");
    }

}