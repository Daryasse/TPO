package eu.glowacki.jaxws.api.composite;

import jakarta.xml.bind.annotation.XmlType;

import java.math.BigInteger;

@XmlType( //
		name = "AddResponseMessage", // name of the XmlType should be different from the name of the class
		namespace = "http://glowacki.eu/composite" //
)
public final class AddResponse {

	public BigInteger result;

	/**
	 * empty parameterless constructor is required for unmarshalling
	 */
	public AddResponse() {
	}

	public AddResponse(BigInteger result) { //
		this.result = result;
	}
}