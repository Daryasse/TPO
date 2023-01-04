package eu.glowacki.jaxws.client.test.bigdata.mtom;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.bigdata.BigData;
import eu.glowacki.jaxws.api.bigdata.IBigDataMTOM;
import jakarta.xml.ws.Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public final class MainNoProxyTest {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
	}

	private IBigDataMTOM _proxy;

	@Before
	public void before() throws MalformedURLException {
		URL wsdl = new URL(eu.glowacki.jaxws.api.bigdata.IBigDataMTOM.URI + IService.WSDL_SUFFIX);
		QName qname = new QName("http://glowacki.eu/big-data/mtom", "BigDataMTOMImplService");
		Service service = Service.create(wsdl, qname);
		_proxy = service.getPort(IBigDataMTOM.class);
	}

	@Test
	public void get() {
		BigData data = _proxy.get();
		Assert.assertNotNull(data);
		LOGGER.info("data: " + data._rawData);
	}
}