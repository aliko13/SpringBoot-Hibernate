package com.example.springdata_hibernate.repository;

import com.example.springdata_hibernate.IntegrationTestHelper;
import com.example.springdata_hibernate.entity.inheritance_strategies.table_per_class.Facebook;
import com.example.springdata_hibernate.entity.inheritance_strategies.table_per_class.Post;
import com.example.springdata_hibernate.entity.inheritance_strategies.table_per_class.Twitter;
import com.example.springdata_hibernate.repository.inheritance_strategies.table_per_class.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TablePerClassInheritanceTest extends IntegrationTestHelper {

    @Autowired
    private PostRepository postRepository;

    @Test
    void thatSavePostWorks() {
        // given
        Post post = new Post();
        post.setTitle("Title");
        post.setDescription("Description");

        // when
        Post savedPost = postRepository.save(post);

        // then
        assertThat(savedPost)
                .extracting(Post::getTitle, Post::getDescription)
                .containsExactly(post.getTitle(), post.getDescription());
    }

    @Test
    void thatSaveTwitterPostWorks() {
        // given
        Twitter twitter = new Twitter();
        twitter.setTitle("Title");
        twitter.setDescription("Description");
        twitter.setFollowers(123);
        twitter.setAccountName("Elan Musk");

        // when
        Twitter savedTwitter = postRepository.save(twitter);

        // then
        assertThat(savedTwitter)
                .extracting(Twitter::getFollowers, Twitter::getAccountName)
                .containsExactly(twitter.getFollowers(), twitter.getAccountName());
    }

    @Test
    void thatSaveFacebookWorks() {
        // given
        Facebook facebook = new Facebook();
        facebook.setTitle("Title");
        facebook.setDescription("Description");
        facebook.setLikes(123);
        facebook.setNumberOfComments(200);

        // when
        Facebook savedFacebook = postRepository.save(facebook);

        // then
        assertThat(savedFacebook)
                .extracting(Facebook::getLikes, Facebook::getNumberOfComments)
                .containsExactly(facebook.getLikes(), facebook.getNumberOfComments());
    }
}
