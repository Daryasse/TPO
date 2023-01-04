package eu.glowacki.jaxws.client.wcf;

import eu.glowacki.jaxws.client.wcf.proxy.CalculatorImpl;
import eu.glowacki.jaxws.client.wcf.proxy.ICalculator;

import java.net.MalformedURLException;
import java.util.logging.Logger;

public final class MainProxyBased {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    public static void main(String... args) throws MalformedURLException {
        CalculatorImpl service = new CalculatorImpl();
        ICalculator proxy = service.getBasicHttpBindingICalculator();
        int sum = proxy.add(1, 2);
        LOGGER.info("sum: " + sum);
    }
}
