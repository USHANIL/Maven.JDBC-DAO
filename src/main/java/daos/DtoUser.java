package daos;

public class DtoUser implements Dto {

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



    public int getId() {
        return 0;
    }
}
