package com.example.demojpa.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository<Post>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> findByPost() {
        System.out.println("Custom Repository...");
        return entityManager.createQuery("SELECT p FROM Post AS p",Post.class).getResultList();
    }

    @Override
    public void delete(Post post) {
        System.out.println("Custom Delete....");
        entityManager.remove(post);
    }



}
