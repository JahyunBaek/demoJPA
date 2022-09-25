package com.example.demojpa.post;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> , JpaSpecificationExecutor<Comment> {

        @EntityGraph(attributePaths = "post",type = EntityGraph.EntityGraphType.FETCH)
        Optional<Comment> findByComment1(String str);


        <T>List<T> findByPost_Id(Long id,Class<T> type);
}
