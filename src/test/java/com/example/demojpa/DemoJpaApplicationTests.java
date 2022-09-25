package com.example.demojpa;

import com.example.demojpa.post.*;
import org.junit.jupiter.api.Test;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/*@Import(PostListnerConfig.class)
@EnableJpaRepositories(repositoryBaseClass = SimpleMyRepository.class)*/
@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void contextLoads() {
    }
    @Test
    void save(){
        Post post = new Post();
        post.setId(1L);
        post.setTitle("JPA");
        Post savePost = postRepository.save(post);

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savePost)).isTrue();
        assertThat(savePost == post);


        Post postUpdate = new Post();
        postUpdate.setId(savePost.getId());
        postUpdate.setTitle("JPAHibernate");
        Post updatePost = postRepository.save(post);

        assertThat(entityManager.contains(postUpdate)).isFalse();
        assertThat(entityManager.contains(updatePost)).isTrue();
        assertThat(postUpdate == updatePost);

        //List<Post> all = postRepository.findByTitleStartingWith("JPAH");
        List<Post> all = postRepository.test("JPA", JpaSort.unsafe("LENGTH(title)"));

        //assertThat(all.size()).isEqualTo(1);
    }
    @Test
    void sort(){
        Post post = new Post();
        post.setId(1L);
        post.setTitle("JPA");
        Post savePost = postRepository.save(post);

        Post postUpdate = new Post();
        postUpdate.setId(savePost.getId());
        postUpdate.setTitle("JPAHibernate");
        Post updatePost = postRepository.save(post);

        List<Post> all = postRepository.test("JPA", JpaSort.unsafe("LENGTH(title)"));

        assertThat(all.size()).isEqualTo(2);
    }
    @Test
    void event(){
        Post post = new Post();
        post.setTitle("event");
        PostPublishedEvent event = new PostPublishedEvent(post);

        applicationContext.publishEvent(event);

    }
    private Post savePost(){
        Post post = new Post();
        post.setTitle("Srping");
        return postRepository.save(post);
    }

    @Test
    void updateTitle(){
        Post spring = savePost();
        spring.setTitle("hibernate");

        Optional<Post> post =  postRepository.findById(spring.getId());
        assertThat(post.get().getTitle()).isEqualTo("hibernate");
    }

    @Test
    void crud()  {
        /*Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post.publish());

        Predicate predicate = QPost.post.title.containsIgnoreCase("Hi");
        Optional<Post> one = postRepository.findOne(predicate);

        assertThat(one).isNotEmpty();
*/
    }

}
