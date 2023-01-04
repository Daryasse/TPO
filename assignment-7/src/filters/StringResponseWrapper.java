package filters;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StringResponseWrapper extends HttpServletResponseWrapper {

    private StringWriter stringWriter = null;

    public StringResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public PrintWriter getWriter(){
        if (stringWriter == null)
            stringWriter = new StringWriter();
        return new PrintWriter(stringWriter);
    }

    public StringWriter getStringWriter() {
        return stringWriter;
    }

}