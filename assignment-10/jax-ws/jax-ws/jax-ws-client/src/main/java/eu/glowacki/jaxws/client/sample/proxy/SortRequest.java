package eu.glowacki.jaxws.client.sample.proxy;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortRequest", propOrder = {"people"})
public class SortRequest {

    @XmlElement(nillable = true)
    protected List<Person> people;

    public List<Person> getPeople() {
        if (people == null) {
            people = new ArrayList<Person>();
        }
        return this.people;
    }

    public void setPeople(List<Person> peopleList) {
        this.people=peopleList;
    }
}

