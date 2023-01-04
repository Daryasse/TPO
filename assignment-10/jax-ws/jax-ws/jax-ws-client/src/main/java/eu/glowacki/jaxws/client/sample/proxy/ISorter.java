package eu.glowacki.jaxws.client.sample.proxy;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

@WebService(name = "ISorter", targetNamespace = "http://glowacki.eu/sorter")
@XmlSeeAlso({ObjectFactory.class})
public interface ISorter {

    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sortBySurname", targetNamespace = "http://glowacki.eu/sorter", className = "eu.glowacki.jaxws.client.sorter.proxy.SortBySurname")
    @ResponseWrapper(localName = "sortBySurnameResponse", targetNamespace = "http://glowacki.eu/sorter", className = "eu.glowacki.jaxws.client.sorter.proxy.SortBySurnameResponse")
    @Action(input = "http://glowacki.eu/sorter/ISorter/sortBySurnameRequest", output = "http://glowacki.eu/sorter/ISorter/sortBySurnameResponse")
    public SortResponse sortBySurname(
            @WebParam(name = "arg0", targetNamespace = "")
                    SortRequest arg0);

    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sortByBirthDate", targetNamespace = "http://glowacki.eu/sorter", className = "eu.glowacki.jaxws.client.sorter.proxy.SortByBirthDate")
    @ResponseWrapper(localName = "sortByBirthDateResponse", targetNamespace = "http://glowacki.eu/sorter", className = "eu.glowacki.jaxws.client.sorter.proxy.SortByBirthDateResponse")
    @Action(input = "http://glowacki.eu/sorter/ISorter/sortByBirthDateRequest", output = "http://glowacki.eu/sorter/ISorter/sortByBirthDateResponse")
    public SortResponse sortByBirthDate(
            @WebParam(name = "arg0", targetNamespace = "")
                    SortRequest arg0);

}
