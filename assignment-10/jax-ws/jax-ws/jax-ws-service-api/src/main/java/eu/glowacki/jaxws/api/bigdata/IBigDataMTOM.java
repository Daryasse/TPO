package eu.glowacki.jaxws.api.bigdata;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.soap.MTOM;

@MTOM
@WebService( //
		name = "IBigDataMTOM", //
		targetNamespace = "http://glowacki.eu/big-data/mtom" //
)
public interface IBigDataMTOM {

	public static final String URI = "http://localhost:8080/big-data/mtom";

	@WebMethod(action = "http://glowacki.eu/big-data/mtom/get")
	BigData get();
}