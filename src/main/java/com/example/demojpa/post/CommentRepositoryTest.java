package com.example.demojpa.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;
    @Test
    public void getComment(){
        /*Comment comment = new Comment();
        Post post = new Post();
        comment.setId(5l);
        comment.setComment("comment");
        comment.setPost(post);

        Comment data = commentRepository.save(comment);*/
        /*Optional<Comment> r1 = commentRepository.findByComment1("aa");
        System.out.println("===============================");
        Optional<Comment> r2 =commentRepository.findById(1l);*/
        //Optional<Comment> r2 =commentRepository.findById(data.getId());


        Comment comment = new Comment();
        Post post = new Post();
        post.setTitle("oo");
        Post savedPost = postRepository.save(post);
        comment.setComment("comment");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(5);
        Comment commnet =  commentRepository.save(comment);
        System.out.println("============================");
        commentRepository.findByPost_Id(savedPost.getId(),CommentSummary.class).forEach(v -> System.out.println("vote==>"+v.getVotes()));

    }

    @Test
    public void specs(){
        Page<Comment> comment =  commentRepository.findAll(CommentSpecs.isBest().and(CommentSpecs.isGood()), PageRequest.of(0,10));
    }

    @Test
    public void que(){
        Comment prove = new Comment();
        prove.setBest(true);

        ExampleMatcher.matching().withIncludeNullValues().withMatcher("best");
    }
}
