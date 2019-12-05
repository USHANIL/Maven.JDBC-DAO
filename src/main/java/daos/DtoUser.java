package daos;

public class DtoUser extends Dto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;

    public DtoUser(Integer id, String firstName, String lastName, String address, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
    }

    public DtoUser(){
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.city = "";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return String.format("User={user id = %d, First Name = %s, Last Name = %s, Address = %s, City = %s}",getId(),getFirstName(),getLastName(),getAddress(),getCity());
    }
}
