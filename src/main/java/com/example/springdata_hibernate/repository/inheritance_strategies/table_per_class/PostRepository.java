package com.example.springdata_hibernate.repository.inheritance_strategies.table_per_class;

import com.example.springdata_hibernate.entity.inheritance_strategies.table_per_class.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> { }
