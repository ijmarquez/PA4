import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Calvin on 5/30/2017.
 */
public class Contact extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();

        //header
        Constants.header(out);

        //body]
        out.println("    <div class=\"footer-contents\">\n" +
                "        <p title=\"Contact Us\" id=\"foorterContentsTitle\">Contact Us</p>\n" +
                "        <p>For questions and concerns, email us at:</p>\n" +
                "        <a href=\"mailto:panteater@uci.edu\">panteater@uci.edu</a>\n" +
                "    </div>");

        //footer
        Constants.footer(out);
    }
}
