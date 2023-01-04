package eu.glowacki.jaxws.api.sorter;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(name = "ISorter", targetNamespace = "http://glowacki.eu/sorter")
public interface ISorter {

    public static final String URI = "http://localhost:8080/sorter";

    @WebMethod(action = "http://glowacki.eu/sorter/sort")
    SortResponse sortBySurname(SortRequest request);
    @WebMethod(action = "http://glowacki.eu/sorter/sort")
    SortResponse sortByBirthDate(SortRequest request);

}
