package be.intecbrussel.data;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 500)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User commentator;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Blog blog;

    public Comment() {
    }
    public Comment(String text) {
        this.text = text;
    }

    public Comment(String text, User commentator) {
        this.text = text;
        this.commentator = commentator;
    }

    public Comment(String text, User commentator, Blog blog) {
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

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", commentator=" + commentator +
                ", blog=" + blog +
                '}';
    }
}
