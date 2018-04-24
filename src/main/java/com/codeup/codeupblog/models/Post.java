package com.codeup.codeupblog.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 200)
    @Size(min = 1, max = 100, message = "Post Title Must be Between 1 and 100 Characters Long")
    private String title;

    @Column(nullable = false, length = 600)
    private String body;

    @OneToOne
    private User owner;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_categories",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Categories> categories;

    public Post() {
    }

    public Post(String title, String body, User owner, List<Categories> categories) {
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.categories = categories;
    }

    public Post(long id, String title, String body, User owner, List<Categories> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}