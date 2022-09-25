package com.example.demojpa.post;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String comment1;

    private int up;

    private int down;

    private boolean best;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    public Long getId() {
        return id;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public boolean isBest() {
        return best;
    }

    public void setBest(boolean best) {
        this.best = best;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment1;
    }

    public void setComment(String comment) {
        this.comment1 = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
