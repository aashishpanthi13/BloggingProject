package com.example.blog.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String blogBody;
    @OneToMany(targetEntity = Comment.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comment> comments;

}
