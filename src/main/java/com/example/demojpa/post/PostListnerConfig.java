package com.example.demojpa.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostListnerConfig {

    @Bean
    public PostListner postListner(){
        System.out.println("Created Bean PostListner...");
        return new PostListner();
    }
}
