package web.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "FirstName should not be empty")
    @Size(min = 2,max = 40,message = "FirstName should be between 2 and 40 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "LastName should not be empty")
    @Size(min = 2,max = 40,message = "LastName should be between 2 and 40 characters")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0,message = "Age should be greater than 0")
    private int age;

    @Column(name = "email")
    @Size(min = 2,max = 40,message = "Email should be between 2 and 40 characters")
    private String email;

    @Column(name = "city")
    @NotEmpty(message = "City should not be empty")
    @Size(min = 2,max = 40,message = "City should be between 2 and 40 characters")
    private String city;

    public User() {
    }

    public User(String firstName, String lastName, int age, String email, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
