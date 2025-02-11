package com.example.blog.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @OneToMany(targetEntity = Blog.class,fetch= FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Blog> blogs;
}
