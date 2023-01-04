package eu.glowacki.jaxws.api.sorter;

import jakarta.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "SortResponse", namespace = "http://glowacki.eu/sorter")
public final class SortResponse{
    public List<Person> result;
    public SortResponse(){}

    public SortResponse(List<Person> result) {
        this.result = result;
    }
}
