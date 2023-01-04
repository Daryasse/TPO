package eu.glowacki.jaxws.client.sample.proxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ByBirthDate", propOrder = {"arg0"})
public class ByBirthDate {
    protected SortRequest arg0;

    public SortRequest getArg0() {
        return arg0;
    }

    public void setArg0(SortRequest value) {
        this.arg0 = value;
    }
}

