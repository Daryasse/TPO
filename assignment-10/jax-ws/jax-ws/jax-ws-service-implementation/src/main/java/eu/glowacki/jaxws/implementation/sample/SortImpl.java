package eu.glowacki.jaxws.implementation.sample;

import eu.glowacki.jaxws.api.sorter.ISorter;
import eu.glowacki.jaxws.api.sorter.Person;
import eu.glowacki.jaxws.api.sorter.SortRequest;
import eu.glowacki.jaxws.api.sorter.SortResponse;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

@WebService(name = "ISorter", targetNamespace = "http://glowacki.eu/sorter")
public final class SortImpl implements ISorter {
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String... args) {
		Endpoint.publish(ISorter.URI, new SortImpl());
		LOGGER.info("SERVICE STARTED");
	}

	public SortImpl() {
	}

	public SortResponse sortBySurname(SortRequest request) {
		java.util.Collections.sort(request.people);
		return new SortResponse(request.people);
	}
	public SortResponse sortByBirthDate(SortRequest request) {
		Collections.sort(request.people, new Comparator<Person>() {
			public int compare(Person person1, Person person2) {
				return person1.getBirthDate().compareTo(person2.getBirthDate());
			}
		});
		return new SortResponse(request.people);
	}
}


