package com.example.springdata_hibernate.entity.inheritance_strategies.table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Facebook extends Post {

    @Column(name = "number_of_comments")
    private int numberOfComments;
    private int likes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}
