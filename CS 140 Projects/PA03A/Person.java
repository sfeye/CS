
public class Person
{
    String name;
    String streetAddress;
    String city;
    String state;
    String zipCode;
    String phoneNumber;

    public Person(String name, String streetAddress, String city, String state, String zipCode, String phoneNumber)
    {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    public String getName()
    {
         return name;
    }
    public String getStreetAddress()
    {
         return streetAddress;
    }
    public String getCity()
    {
         return city;
    }
    public String getState()
    {
         return state;
    }
    public String getZipCode()
    {
         return zipCode;
    }
    public String getPhoneNumber()
    {
         return phoneNumber;
    }
    
     public void setName(String name)
    {
         this.name = name;
    }
    public void setStreetAddress(String address)
    {
         streetAddress = address;
    }
    public void setCity(String city)
    {
         this.city = city;
    }
    public void setState(String state)
    {
         this.state = state;
    }
    public void setZipCode(String zipcode)
    {
         zipCode = zipcode;
    }
    public void setPhoneNumber(String number)
    {
         phoneNumber = number;
    }
    public void printMailingLabel()
    {
        System.out.println(name);
        System.out.println(streetAddress);
        System.out.println(city + ", " + city + " " + zipCode);
    }
}
