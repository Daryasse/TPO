package eu.glowacki.jaxws.client.sample;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.sample.proxy.ISorter;
import eu.glowacki.jaxws.client.sample.proxy.SortRequest;
import eu.glowacki.jaxws.client.sample.proxy.SortResponse;
import eu.glowacki.jaxws.client.sample.proxy.SortService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public final class MainNoProxy {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    }

    public SortResponse mainWithSortBySurname(SortRequest request) throws MalformedURLException {
        URL url = new URL(eu.glowacki.jaxws.api.sorter.ISorter.URI + IService.WSDL_SUFFIX);
        SortService service = new SortService(url);
        ISorter sorter = service.getISorterPort();
        SortResponse result = sorter.sortBySurname(request);
        return result;
    }
    public SortResponse mainWithSortByBirthDate(SortRequest request) throws MalformedURLException {
        URL url = new URL(eu.glowacki.jaxws.api.sorter.ISorter.URI + IService.WSDL_SUFFIX);
        SortService service = new SortService(url);
        ISorter sorter = service.getISorterPort();
        SortResponse result = sorter.sortByBirthDate(request);
        return result;
    }
}