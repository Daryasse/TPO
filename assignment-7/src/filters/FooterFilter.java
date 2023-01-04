package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@WebFilter(filterName = "FooterFilter", urlPatterns = {"*.jsp","*.servlet"})
public class FooterFilter implements Filter{

    public void init(FilterConfig p0) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException,ServletException {

        StringResponseWrapper newResp = new StringResponseWrapper(
                (HttpServletResponse) response);
        chain.doFilter(request, newResp);
        StringWriter stringWriter = newResp.getStringWriter();
        String cont = stringWriter.toString();
        PrintWriter out = response.getWriter();
        out.println(cont);

        out.println("<div id=\"date\">"+new Date() +"</div> ");
        out.close();
    }

    public void destroy() {
    }
}