package be.intecbrussel.data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column()
    private String password;

    @Column(  length = 40)
    private String name;

    //nick·name
    @Column( length = 40, unique = true)
    private String userName;

    @Column( length = 40)
    private String street;

    @Column(  length = 40)
    private int houseNr;

    @Column( length = 40)
    private String city;

    @Column(  length = 40)
    private int ZIP;

    @Column
    private Date date;

    @OneToMany(mappedBy = "commentator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;


    public User() {
    }

    public User(  String userName, String password ) {
        this.userName = userName;
        this.password = password;
    }

    public User(String email, String password, String name, String userName, String street, int houseNr, String city, int ZIP) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userName = userName;
        this.street = street;
        this.houseNr = houseNr;
        this.city = city;
        this.ZIP = ZIP;
    }

    public User(String email, String password,
                String name, String userName, String street, int houseNr,
                String city, int ZIP, Date date, List<Comment> comments) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userName = userName;
        this.street = street;
        this.houseNr = houseNr;
        this.city = city;
        this.ZIP = ZIP;
        this.date = date;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZIP() {
        return ZIP;
    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "User: " +

                 userName ;
    }
}
