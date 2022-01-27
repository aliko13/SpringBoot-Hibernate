package com.example.springdata_hibernate.repository.table_per_class;

import com.example.springdata_hibernate.entity.table_per_class.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> { }
