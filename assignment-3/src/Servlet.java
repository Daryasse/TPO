import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Servlet extends HttpServlet {
    Integer sum = 0;
    static final String regex = "^[0-9]+$";
    Pattern pattern = Pattern.compile(regex);

    private void htmlAnswer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String charset = "ISO8859-2";
        request.setCharacterEncoding(charset);
        response.setContentType("text/html; charset=" + charset);
        PrintWriter out = response.getWriter();
        String responseFile = getInitParameter("responseFile");
        ServletContext context = getServletContext();
        InputStream input = context.getResourceAsStream("/WEB-INF/" + responseFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = br.readLine()) != null) out.println(line);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        htmlAnswer(request, response);
        proccessRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        htmlAnswer(request, response);
        proccessRequest(request, response);
    }

    protected void proccessRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sum = 0;
        PrintWriter out = response.getWriter();
        String method = request.getMethod();

        out.println(method);
        out.println();

        Matcher match1 = pattern.matcher(request.getParameter("component1"));
        Matcher match2 = pattern.matcher(request.getParameter("component2"));
        if (!match1.matches() | !match2.matches()) {
            out.println("---INVALID INPUT---");
        }

        Integer component1 = Integer.valueOf(request.getParameter("component1"));
        Integer component2 = Integer.valueOf(request.getParameter("component2"));

        sum = component1 + component2;
        out.println("Sum equals " + sum);
    }
}
