package eu.glowacki.jaxws.client.sample.proxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person_", propOrder = {"birthDate", "firstName", "surname"})
public class Person {
    protected Date birthDate;
    protected String firstName;
    protected String surname;

    public Person(String firstName, String surname, Date birthDate){
        this.firstName = firstName;
        this.surname = surname;
        this.birthDate = birthDate;
    }
    public Person(){}

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date value) {
        this.birthDate = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String value) {
        this.surname = value;
    }

}
