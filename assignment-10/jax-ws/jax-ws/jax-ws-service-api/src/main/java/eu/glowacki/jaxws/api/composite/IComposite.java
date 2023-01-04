package eu.glowacki.jaxws.api.composite;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService( //
		name = "IComposite", //
		targetNamespace = "http://glowacki.eu/composite" //
)
public interface IComposite {

	public static final String URI = "http://localhost:8080/composite";

	@WebMethod(action = "http://glowacki.eu/composite/add")
	AddResponse add(AddRequest request);
}