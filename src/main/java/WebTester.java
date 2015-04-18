
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import java.io.IOException;

public class WebTester extends HttpServlet {
  
  public static final Logger log = Logger.getLogger(WebTester.class.getName());
  private static final long serialVersionUID = 1L;
  
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
throws IOException
  {
     resp.setContentType("text/plain");
     EveApi eveApi = new EveApi(4300877, "CViRCKn7XRWC3UaVXZ0dkgl0QE7DPsypBPOZn3Y240bubHJ1ZfU4dtWC30lC6lSU", "Tedt");
	  log.info("Success");
  }
  
}
