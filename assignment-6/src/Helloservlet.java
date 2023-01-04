import javax.servlet.http.*;
import java.io.*;

public class Helloservlet extends HttpServlet{
    public static String regex = "[0-9]+";

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws
            IOException{
        summing(request, response);
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws
            IOException{
        summing(request, response);
    }
    public static void summing(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer component1 = Integer.valueOf(request.getParameter("component1"));
        Integer component2 = Integer.valueOf(request.getParameter("component2"));
        if(String.valueOf(component1).matches(regex) && String.valueOf(component2).matches(regex)){
        Integer sum = component1 + component2;
        response.getWriter().write(String.valueOf(sum));
        }
    }
}
