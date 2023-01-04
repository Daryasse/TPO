package eu.glowacki.jaxws.client.sample.proxy;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BySurnameResponse", propOrder = {"_return"})
public class BySurnameResponse {
    @XmlElement(name = "return")
    protected SortResponse _return;

    public SortResponse getReturn() {
        return _return;
    }

    public void setReturn(SortResponse value) {
        this._return = value;
    }

}
