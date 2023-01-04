import eu.glowacki.jaxws.client.sample.MainNoProxy;
import eu.glowacki.jaxws.client.sample.proxy.Person;
import eu.glowacki.jaxws.client.sample.proxy.SortRequest;
import eu.glowacki.jaxws.client.sample.proxy.SortResponse;
import eu.glowacki.jaxws.implementation.sample.SortImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.net.MalformedURLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public final class SortImplTest {

    static List<Person> people = new ArrayList();
    MainNoProxy mainNoProxy = new MainNoProxy();

    @BeforeAll
    static void fullList(){
        Person p1 = new Person("Anna","Desh",Date.valueOf("1998-04-24"));
        people.add(p1);
        Person p2 = new Person("Dima", "Valuev", Date.valueOf("2000-09-10"));
        people.add(p2);
        Person p3 = new Person("Kirill", "Baduev", Date.valueOf("2008-05-03"));
        people.add(p3);
        Person p4 = new Person("Vika","Abramov", Date.valueOf("1992-09-20"));
        people.add(p4);
        Person p5 = new Person("Nikita", "Korneev", Date.valueOf("1990-02-01"));
        people.add(p5);
    }

    @Test
    public void sortByBirthDate() throws MalformedURLException {
        SortRequest request = new SortRequest();
        request.setPeople(people);
        SortResponse responseByBirthDate = mainNoProxy.mainWithSortByBirthDate(request);
        Assert.assertEquals(("Korneev"), responseByBirthDate.getResult().get(0).getSurname());
        Assert.assertEquals(("Abramov"), responseByBirthDate.getResult().get(1).getSurname());
    }
    @Test
    public void sortBySurname() throws MalformedURLException {
        SortRequest request = new SortRequest();
        request.setPeople(people);
        SortResponse responseBySurname = mainNoProxy.mainWithSortBySurname(request);
        Assert.assertEquals("Abramov",responseBySurname.getResult().get(0).getSurname());
        Assert.assertEquals("Baduev",responseBySurname.getResult().get(1).getSurname());
    }
}
