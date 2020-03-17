package io.instacode.treehouse.java.course;

import io.instacode.treehouse.java.core.BaseEntity;
import io.instacode.treehouse.java.review.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course extends BaseEntity {
    private String title;
    private String url;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course() {
        super();
        reviews = new ArrayList<>();
    }

    public Course(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        review.setCourse(this);
        reviews.add(review);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
