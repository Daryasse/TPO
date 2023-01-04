package eu.glowacki.jaxws.api.bigdata;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService( //
		name = "IBigDataStandard", //
		targetNamespace = "http://glowacki.eu/big-data/standard" //
)
public interface IBigDataStandard {
	
	public static final String URI = "http://localhost:8080/big-data/standard";

	@WebMethod(action = "http://glowacki.eu/big-data/standard/get")
	BigData get();
}