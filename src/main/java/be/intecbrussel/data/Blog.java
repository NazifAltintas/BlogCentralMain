package be.intecbrussel.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 1000)
    private String text;

    @Column(nullable = false, unique = true, length = 60)
    private String title;

    // for picture jpg
    private String link;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Auteur auteur;

    @Column
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments= new ArrayList<>();

    public Blog() {
    }

    public Blog(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public Blog(List<Comment> comments) {
        this.comments = comments;
    }

    public Blog(String text, String title, String link, Auteur auteur, LocalDateTime dateTime, List<Comment> comments) {
        this.text = text;
        this.title = title;
        this.link = link;
        this.auteur = auteur;
        this.dateTime = dateTime;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", auteur=" + auteur +
                ", dateTime=" + dateTime +
                ", comments=" + comments +
                '}';
    }
}

