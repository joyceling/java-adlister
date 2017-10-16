import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name="Counter", urlPatterns = "/counter")
public class Counter extends HttpServlet {
    int counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String resetCounter = req.getParameter("reset");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if (resetCounter == "true") {
            counter = 0;
        } else {
            out.println("Page counter: " + counter);
            counter++;
        }


    }

}
