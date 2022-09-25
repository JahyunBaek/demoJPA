package com.example.demojpa.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findByPost();

    void delete(T post);
}
