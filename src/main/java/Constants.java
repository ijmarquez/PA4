import javax.ws.rs.core.UriBuilder;
import java.io.PrintWriter;
import java.net.URI;

/**
 * Created by Calvin on 5/24/2017.
 */
public class Constants {

    public static void header(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/header_footer.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/home.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/footerContent.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/items_list.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/items.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/buyItem.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/customerOrder.css\">");
        out.println("<script type=\"text/javascript\" src=\"js/buyItem.js\"></script>");
        out.println("<script type=\"text/javascript\" src=\"js/item.js\"></script>");
        out.println("<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">");
        out.println("<script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>");
        out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js\"></script>");
        out.println("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css\" rel=\"stylesheet\">");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js\"></script>");
        out.println("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\">");
        out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js\"></script>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-3-typeahead/4.0.1/bootstrap3-typeahead.min.js\"></script>");
        out.println("</head>");
        out.println("<title> Clothing Couture </title>");
        out.println("<body>");
        out.println("<div class=\"pageContainer\">");
        out.println("<div class=\"homeContainer\">");
        out.println("<div class=\"home-logo\">");
        out.println("<h1>Clothing Couture</h1>");
        out.println("</div>");
        out.println("<div class=\"navMenu\">");
        out.println("<ul class=\"navBar\">");
        out.println("<li> <a class=\"userOption\" href=\"home\"> Welcome </a> </li>");
        out.println("<li> <a class=\"userOption\" href=\"itemsList.jsp\"> Home </a> </li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</div>");
    }

    public static void footer(PrintWriter out) {
        out.println("<footer>");
        out.println("<div class=\"footer\">");
        out.println("<a class=\"footerOption\" href=\"About\">About us</a>");
        out.println("<a class=\"footerOption\" href=\"Contact\">Contact us</a>");
        out.println("</div>");
        out.println("</footer>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    public static String getDatabaseName() {
        return "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu/inf124-db-063";
    }

    public static String getUsername() {
        return "inf124-db-063";
    }

    public static String getPassword() { return "GSaxgpMPZKhN"; }

    public static URI getBaseURI() {
        //Change the URL here to make the client point to your service.
        return UriBuilder.fromUri("http://andromeda-74.ics.uci.edu:23456/jerseyrest").build();
    }

    public static String getPOSTURL() { return "http://andromeda-74.ics.uci.edu:23456/jerseyrest/v1/api/todos";}
}


//out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");