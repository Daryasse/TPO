package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener extends ListenerBase implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent event) {
        logger.severe("REQUEST INITIALIZED "+event.toString());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
      logger.severe("REQUEST DESTROYED "+event.toString());
    }

}