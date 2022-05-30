package be.intecbrussel.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commentator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 8)
    private String password;

    @Column( nullable = false, length = 40)
    private String name;

    //nick·name
    @Column( nullable = false, length = 40, unique = true)
    private String UserName;

    @Column( length = 40)
    private int Street;

    @Column(  length = 40)
    private int HouseNr;

    @Column( length = 40)
    private String City;

    @Column(  length = 40)
    private int ZIP;

    @OneToMany(mappedBy = "commentator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;


    public Commentator() {
    }

    public Commentator(String email, String password, String name,
                       String userName, int street, int houseNr,
                       String city, int ZIP, List<Comment> comments) {
        this.email = email;
        this.password = password;
        this.name = name;
        UserName = userName;
        Street = street;
        HouseNr = houseNr;
        City = city;
        this.ZIP = ZIP;
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
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getStreet() {
        return Street;
    }

    public void setStreet(int street) {
        Street = street;
    }

    public int getHouseNr() {
        return HouseNr;
    }

    public void setHouseNr(int houseNr) {
        HouseNr = houseNr;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
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



}
