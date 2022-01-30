package com.example.springdata_hibernate.entity.inheritance_strategies.table_per_class;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Post {

    /**
     * TABLE_PER_CLASS does not support GenerationType.AUTO or GenerationType.IDENTITY
     */
    @GeneratedValue(generator = "POST_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "POST_SEQ", sequenceName = "post_sequence", allocationSize = 10)
    @Id
    @Column(updatable = false)
    private int id;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
