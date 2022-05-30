package be.intecbrussel.data;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Commentator commentator;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Blog blog;

    public Comment() {
    }

    public Comment(String text, Commentator commentator, Blog blog) {
        this.text = text;
        this.commentator = commentator;
        this.blog = blog;
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

    public Commentator getCommentator() {
        return commentator;
    }

    public void setCommentator(Commentator commentator) {
        this.commentator = commentator;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
