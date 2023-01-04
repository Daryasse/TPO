package listeners;
import javax.servlet.*;

public class ContextListener extends ListenerBase implements ServletContextListener{

    public void contextInitialized(ServletContextEvent p0) {
        logger.severe("CONTEXT INITIALIZED");
        ServletContext context = p0.getServletContext();
        context.setAttribute("n", 1);
    }

    public void contextDestroyed(ServletContextEvent p0) {
       logger.severe("CONTEXT DESTROYED");
    }
}