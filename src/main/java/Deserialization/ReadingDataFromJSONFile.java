package Deserialization;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

class Person
{
    private String firstNam;
    private String lastName;

    private List<Address> address;

    public String getFirstName() {
        return firstNam;
    }

    public void setFirstName(String firstName) {
        this.firstNam = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String toString()
    {
        return getFirstName() +" " + getLastName() +" "+ getAddress();
    }
}

class Address
{
    private String street;
    private String city;
    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
public class ReadingDataFromJSONFile
{

    public static void main(String[] args) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("C:\\Users\\subha\\Desktop\\RestAssuredProject\\src\\main\\resources\\employee.json");

        //Read JSON Data from json file and map to Person class
        Person person = objectMapper.readValue(file, Person.class);

        //Access the data
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());

        for(Address ad : person.getAddress())
        {
            System.out.println(ad.getCity());
            System.out.println(ad.getState());
            System.out.println(ad.getStreet());
        }

    }
}
