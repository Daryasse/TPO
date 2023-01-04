import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/regex")
public class Hello extends HttpServlet {

    public final static String component1 = "component1";
    public final static String component2 = "component2";
    public final static String regex = "regex";

    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException {
        String result = "";
        Pattern pattern = null;
        String requestRegex = request.getParameter(component1);
        String requestString = request.getParameter(component2);

        try {
            pattern = Pattern.compile(requestRegex);
        } catch (Exception e) {
            result = "ENTERED PATTERN IS NOT A REGULAR EXPRESSION";
        }

        Matcher matcher = pattern.matcher(requestString);
        StringBuilder resultBuilder = new StringBuilder(result);
        while (matcher.find()) {
            resultBuilder.append(" ").append(matcher.group()).append("<start-index> ").append(matcher.start()).append(", <end-index> ").append(matcher.end());
        }
        result = resultBuilder.toString();
        if (result.isBlank()) {
            result = "NO MATCHES FOUND";
        }

        PrintWriter out = response.getWriter();
        out.write("{ \"" + regex + "\": \"" + result + "\"}");
        out.close();

    }
}
