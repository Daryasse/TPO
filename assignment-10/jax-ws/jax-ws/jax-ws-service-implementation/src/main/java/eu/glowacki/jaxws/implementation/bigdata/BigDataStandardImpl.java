package eu.glowacki.jaxws.implementation.bigdata;

import eu.glowacki.jaxws.api.bigdata.BigData;
import eu.glowacki.jaxws.api.bigdata.IBigDataStandard;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

import java.util.logging.Logger;

@WebService( //
		name = "IBigDataStandard", //
		targetNamespace = "http://glowacki.eu/big-data/standard" //
)
public final class BigDataStandardImpl implements IBigDataStandard {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String... args) {
		Endpoint.publish(IBigDataStandard.URI, new BigDataStandardImpl());
		LOGGER.info("SERVICE STARTED");
	}

	@WebMethod
	public BigData get() {
		BigData data = BigData.generate();
		return data;
	}
}