package com.example.demojpa.post;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class PostListner{

    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("--------------");
        System.out.println(event.getPost().getTitle() + " is PostListener");
        System.out.println("--------------");
    }
}
