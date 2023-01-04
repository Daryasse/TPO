import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServletController extends HttpServlet {
    static final String regex = "^[0-9]+$";
    Pattern pattern = Pattern.compile(regex);
    Logic logic = new Logic();



    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        proccessRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        proccessRequest(request, response);
    }

    protected void proccessRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String method = request.getMethod();

        out.println(method);
        out.println();

        Model model = logic.process(request.getParameter("component1"),
                request.getParameter("component2"), pattern);
        request.setAttribute("model", model);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(ServletView.URL);
        dispatcher.forward(request, response);
    }
}
