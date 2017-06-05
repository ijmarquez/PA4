import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Calvin on 5/30/2017.
 */
public class About extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        //header
        Constants.header(out);

        //body]
        out.println("  <div class=\"footer-contents\">\n" +
                "    <p title=\"About Us\" id=\"footerContentsTitle\">About Us</p>\n" +
                "\t<p class=\"footerContentText\">We want to help you feel better by looking better. Our business was established in 2017. Our goal is to\n" +
                "\t\tsell stylish, high-quality clothes that are also comfortable and easy for our customers to wear.</p>\n" +
                "    <p>We appreciate your business.</p>\n" +
                "\t<p>-- Clothing Couture Team (Irish Marquez and Calvin Poon)</p>\n" +
                "  </div>");

        //footer
        Constants.footer(out);
    }
}
