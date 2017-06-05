import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by walki on 5/24/2017.
 */
@WebServlet("/ItemsList")
public class ItemsList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        //connect to the DB information
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = Constants.getDatabaseName();
        final String DB_USER = Constants.getUsername();
        final String DB_PASS = Constants.getPassword();
        Connection conn = null;
        Statement stmt = null;

        PrintWriter out = response.getWriter();

        //header
        Constants.header(out);

        //this is where it'll show the list of different items
        out.println("<div class=\"items-container\">");
        out.println("<div class=\"items-contents\">");
        out.println("<table class=\"itemListTable\">");

        //insert each item in a loop here
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

        out.println("<hr>");

        // Previously-viewed items, param is the servlet name
        RequestDispatcher rd = request.getRequestDispatcher("PreviousItemsViewed");
        rd.include(request, response);

        //footer
        Constants.footer(out);
    }
}
