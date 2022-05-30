package be.intecbrussel.data;

import javax.persistence.*;
import java.util.List;

@Entity

public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 8)
    private String password;

    @Column( nullable = false, length = 40)
    private String name;

    @OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Blog> blogs;

    public Auteur() {
    }

    public Auteur(String email, String password, String name, List<Blog> blogs) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.blogs = blogs;
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

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
