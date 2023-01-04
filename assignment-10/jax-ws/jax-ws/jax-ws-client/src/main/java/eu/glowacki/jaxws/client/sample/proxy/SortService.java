package eu.glowacki.jaxws.client.sample.proxy;

import jakarta.xml.ws.*;
import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "SorterImplService", targetNamespace = "http://glowacki.eu/sorter", wsdlLocation = "http://localhost:8080/sorter?wsdl")
public class SortService extends Service{

    private final static URL SORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException SORTSERVICE_EXCEPTION;
    private final static QName SORTSERVICE_QNAME = new QName("http://glowacki.eu/sorter", "SortImplService");

    static {
        URL url = null;
        WebServiceException exception = null;
        try {
            url = new URL("http://localhost:8080/sorter?wsdl");
        } catch (MalformedURLException ex) {
            exception = new WebServiceException(ex);
        }
        SORTSERVICE_WSDL_LOCATION = url;
        SORTSERVICE_EXCEPTION = exception;
    }

    public SortService() {
        super(getWsdlLocation(), SORTSERVICE_QNAME);
    }

    public SortService(WebServiceFeature... features) {
        super(getWsdlLocation(), SORTSERVICE_QNAME, features);
    }

    public SortService(URL wsdlLocation) {
        super(wsdlLocation, SORTSERVICE_QNAME);
    }

    public SortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SORTSERVICE_QNAME, features);
    }

    public SortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "ISorterPort")
    public ISorter getISorterPort() {
        return super.getPort(new QName("http://glowacki.eu/sorter", "ISorterPort"), ISorter.class);
    }

    @WebEndpoint(name = "ISorterPort")
    public ISorter getISorterPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://glowacki.eu/sorter", "ISorterPort"), ISorter.class, features);
    }

    private static URL getWsdlLocation() {
        if (SORTSERVICE_EXCEPTION != null) {
            throw SORTSERVICE_EXCEPTION;
        }
        return SORTSERVICE_WSDL_LOCATION;
    }

}
