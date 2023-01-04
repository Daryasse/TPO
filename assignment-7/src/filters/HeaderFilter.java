package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "HeaderFilter", urlPatterns = {"*.jsp"})
public class HeaderFilter implements Filter {

    private String header =
            "  <html>\n" +
                    "  <head>\n" +
                    "    <script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n" +
                    "    <script type=\"text/javascript\" language=\"javascript\" src=\"index.js\"></script>\n" +
                    " </head> <body><table cellpadding=2 cellspacing=2 border=1 width=100%>" +
                    "<tbody><tr><td valign=Top bgcolor=#FF09B49/>" +
                    "<div align=Center><font color=#ffffff>@</font></div></td>" +
                    "</tr></tbody></table>";

    private String name;

    public void init(FilterConfig fc) throws ServletException {
        name = "Task 7";
        name = header.replaceFirst("@", name);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println(name);
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}