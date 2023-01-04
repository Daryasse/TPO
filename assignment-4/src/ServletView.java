import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServletView extends HttpServlet {
    static String URL = "/servletv";

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
    protected void service (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        PrintWriter writer = response.getWriter();
        Model model = (Model) request.getAttribute("model");
        htmlAnswer(request, response);
        writer.println("Sum equals " + model.getSum());
    }
}
