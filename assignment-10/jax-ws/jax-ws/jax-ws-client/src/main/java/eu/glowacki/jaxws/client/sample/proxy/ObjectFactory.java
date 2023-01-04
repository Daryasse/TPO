package eu.glowacki.jaxws.client.sample.proxy;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _SortByBirthDate_QNAME = new QName("http://glowacki.eu/sorter", "sortByBirthDate");
    private final static QName _SortByBirthDateResponse_QNAME = new QName("http://glowacki.eu/sorter", "sortByBirthDateResponse");
    private final static QName _SortBySurname_QNAME = new QName("http://glowacki.eu/sorter", "sortBySurname");
    private final static QName _SortBySurnameResponse_QNAME = new QName("http://glowacki.eu/sorter", "sortBySurnameResponse");

    public ObjectFactory() {
    }

    public ByBirthDate createSortByBirthDate() {
        return new ByBirthDate();
    }

    public ByBirthDateResponse createSortByBirthDateResponse() {
        return new ByBirthDateResponse();
    }

    public BySurname createSortBySurname() {
        return new BySurname();
    }

    public BySurnameResponse createSortBySurnameResponse() {
        return new BySurnameResponse();
    }

    public SortRequest createSortRequestMessage() {
        return new SortRequest();
    }

    public Person createPersonMessage() {
        return new Person();
    }

    public SortResponse createSortResponseMessage() {
        return new SortResponse();
    }

    @XmlElementDecl(namespace = "http://glowacki.eu/sorter", name = "ByBirthDate")
    public JAXBElement<ByBirthDate> createSortByBirthDate(ByBirthDate value) {
        return new JAXBElement<ByBirthDate>(_SortByBirthDate_QNAME, ByBirthDate.class, null, value);
    }

    @XmlElementDecl(namespace = "http://glowacki.eu/sorter", name = "ByBirthDateResponse")
    public JAXBElement<ByBirthDateResponse> createSortByBirthDateResponse(ByBirthDateResponse value) {
        return new JAXBElement<ByBirthDateResponse>(_SortByBirthDateResponse_QNAME, ByBirthDateResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://glowacki.eu/sorter", name = "BySurname")
    public JAXBElement<BySurname> createSortBySurname(BySurname value) {
        return new JAXBElement<BySurname>(_SortBySurname_QNAME, BySurname.class, null, value);
    }

    @XmlElementDecl(namespace = "http://glowacki.eu/sorter", name = "BySurnameResponse")
    public JAXBElement<BySurnameResponse> createSortBySurnameResponse(BySurnameResponse value) {
        return new JAXBElement<BySurnameResponse>(_SortBySurnameResponse_QNAME, BySurnameResponse.class, null, value);
    }

}
