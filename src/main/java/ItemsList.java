import model.MainList;
import model.Todo;
import org.glassfish.jersey.client.ClientConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;
import java.sql.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.ClientConfig;


/**
 * Created by walki on 5/24/2017.
 */
@WebServlet("/ItemsList")
public class ItemsList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();

        //header
        Constants.header(out);

        //this is where it'll show the list of different items
        out.println("<div class=\"items-container\">");
        out.println("<div class=\"items-contents\">");
        out.println("<table class=\"itemListTable\">");

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

        //call the GET in API
        List<MainList> todoList = objectMapper.readValue(jsonResponse, new TypeReference<List<MainList>>(){});

        //insert each item in a loop here
        int i = 1;
        for(MainList todo : todoList)
        {
            if ( i == 1) {
                out.println("<tr>");
            }
            if(i == 5) {
                out.println("</tr>");
                i = 1;
            }
            out.println("<td>");

            String generalName = todo.getGeneralName();
            String imageLocation = todo.getLocation();
            String cost = todo.getCost();

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

        out.println("</table>");
        out.println("</div>");

        out.println("<hr>");

        // Previously-viewed items, param is the servlet name
        RequestDispatcher rd = request.getRequestDispatcher("PreviousItemsViewed");
        rd.include(request, response);

        //footer
        Constants.footer(out);
    }
}
