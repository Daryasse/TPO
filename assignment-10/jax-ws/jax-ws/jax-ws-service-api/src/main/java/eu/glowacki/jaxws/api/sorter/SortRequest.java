package eu.glowacki.jaxws.api.sorter;

import jakarta.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "SortRequest", namespace = "http://glowacki.eu/sorter")
public final class SortRequest {

    public List<Person> people;

    public SortRequest() {
    }

    public SortRequest(List<Person> people) {
        this.people = people;
    }
}
