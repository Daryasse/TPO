package eu.glowacki.jaxws.api.sorter;

import jakarta.xml.bind.annotation.XmlType;

import java.util.Date;

@XmlType(name = "Person_", namespace = "http://glowacki.eu/sorter")
public class Person implements Comparable<Person>{

    private String firstName;
    private String surname;
    private Date birthDate;

    public int compareTo(Person person) {
        return this.surname.compareTo(person.getSurname());
    }

    public Person(){}

    public Person(String _firstName, String _surname, Date _birthdate) {
        firstName = _firstName;
        surname = _surname;
        birthDate = _birthdate;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "Person: " +
                "FirstName = " + firstName + ", Surname=" + surname + ", BirthDate=" + birthDate;
    }


}
