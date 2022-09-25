package com.example.demojpa.post;

import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {

    String getComment1();

    int getUp();

    int getDown();

    default String getVotes(){
        return getUp() + " " + getDown();
    }

  /*  @Value("#{target.up  + target.down}")
    String getVotes();*/
}
