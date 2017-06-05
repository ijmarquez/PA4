import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by irishmarquez on 5/26/17.
 */
@WebServlet(name = "PreviousItemsViewed")
public class PreviousItemsViewed extends HttpServlet {
 //   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // access viewedList through session
        HttpSession session = request.getSession();

        //create a list to handle viewedList from session
        List<ItemModel> viewedList = (ArrayList)session.getAttribute("viewedList");

        // output of PreviousItemsViewed servlet
        out.println("<div class='items-viewed-container'>");
        out.println("<div class='items-viewed'>");

        //if viewList is not empty, prints previous viewed Items
        if (viewedList != null)
        {
            out.println("<h2> Previous Viewed Items:");
            out.println("<table class=\"previousItems\">");
            out.println("<tr>");
            for (int i = 0; i < viewedList.size(); ++i) {
                out.println("<td>");

                // get item at index i from viewedList
                ItemModel it = viewedList.get(i);
                String genName = it.getGeneralName();
                String url = it.getImageLocation();

                // uses genName and url for href
                out.println("<a href=\"Item?product='" + genName + "'&amp;image='" + url + "'\">");
                out.println("<img class=\"image_thumbnail\" src= \"" + url + "\" alt= \"" + genName + "\"></a>");
                out.println("</td>");
            }

            out.println("</tr>");
            out.println("</table>");
            out.println("</div>"); // items-viewed
        }
    } // end doGet
}   // end class


