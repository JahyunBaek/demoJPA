package com.example.demojpa.post;

import com.example.demojpa.MyRepository;
import com.example.demojpa.SimpleMyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>, QuerydslPredicateExecutor<Post> {

    List<Post> findByTitleStartingWith(String str);

    @Query(value = "SELECT p FROM #{#entityName} AS p WHERE p.title = :title",nativeQuery = false)
    List<Post> test(@Param("title") String str, Sort sort);

    @Transactional
    @Modifying()
    @Query(value = "UPDATE Post p set p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String title, Long id);
}
