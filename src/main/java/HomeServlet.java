import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by irishmarquez on 5/22/17.
 */
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        // create a viewedList and add to session
        //List<model.ItemModel> viewedList = new ArrayList<model.ItemModel>();
        //session = request.getSession();
        //session.setAttribute("viewedList", viewedList);

        PrintWriter out = response.getWriter();

        //header
        Constants.header(out);

        //body]
        out.println(" <div class=\"home-contents\">");
        out.println("<p id=\"home-hook\">Style. Comfort. Easy.</p>");
        out.println("<a id=\"userHomeItemList\" href=\"itemsList.jsp\">Enter</a>");
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}