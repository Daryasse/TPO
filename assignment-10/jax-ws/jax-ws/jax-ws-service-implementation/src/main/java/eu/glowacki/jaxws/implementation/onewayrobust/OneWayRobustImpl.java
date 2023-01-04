package eu.glowacki.jaxws.implementation.onewayrobust;

import eu.glowacki.jaxws.api.ServiceException;
import eu.glowacki.jaxws.api.onewayrobust.IOneWayRobust;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

import java.util.logging.Logger;

@WebService( //
		name = "IOneWayRobust", //
		targetNamespace = "http://glowacki.eu/one-way-robust" //
)
public final class OneWayRobustImpl implements IOneWayRobust {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String... args) {
		Endpoint.publish(IOneWayRobust.URI, new OneWayRobustImpl());
		LOGGER.info("SERVICE STARTED");
	}

	public void trigger(String input) throws ServiceException {
		LOGGER.info("triggerNotRobust (RECEIVED) " + input);
	}

	@Override
	public void triggerNotRobust(String input) {
		LOGGER.info("triggerNotRobust (RECEIVED) " + input);
	}
}