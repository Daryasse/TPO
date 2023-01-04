import listeners.ListenerBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/date")
public class HelloServlet extends HttpServlet {

    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final Pattern NUMBER_REGEX = Pattern.compile(NUMBER_PATTERN);

    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void init() {
        ListenerBase.add("SERVLET INITIALIZED");
    }

    private static BigInteger parameters(HttpServletRequest req, String name) {
        String parameter = (String) req.getParameter(name);
        return parse(parameter);
    }

    private static BigInteger parse(String input) {
        if (input == null) return null;
        Matcher matcher = NUMBER_REGEX.matcher(input);
        if (matcher.matches()) {
            return new BigInteger(input);
        }
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Integer c1 = Integer.valueOf(request.getParameter("text1"));
        Integer c2 = Integer.valueOf(request.getParameter("text2"));
        if (c1 == null || c2 == null) {
        } else {
            Integer sum = c1 + c2;
            out.write(String.valueOf(sum));
        }
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        Date now = new Date();
        String string = FORMAT.format(now);
        PrintWriter out = response.getWriter();
        out.println("{ currentTime: " + string + " }");
        out.close();
    }
}
