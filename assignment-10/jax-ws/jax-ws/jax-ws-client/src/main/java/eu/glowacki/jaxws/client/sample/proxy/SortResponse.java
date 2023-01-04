package eu.glowacki.jaxws.client.sample.proxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortResponse", propOrder = {"result"})
public class SortResponse {

    @XmlElement(nillable = true)
    protected List<Person> result;

    public List<Person> getResult() {
        if (result == null) {
            result = new ArrayList<Person>();
        }
        return this.result;
    }

}
