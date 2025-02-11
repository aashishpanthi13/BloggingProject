package com.example.blog.ServiceImplt;

import com.example.blog.Entity.Blog;
import com.example.blog.Entity.User;
import com.example.blog.Repo.BlogRepo;
import com.example.blog.Repo.UserRepo;
import com.example.blog.Service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class BlogServiceImplt implements BlogService {
    private final BlogRepo blogRepo;
    private final UserRepo userRepo;


    @Override
    public Blog addBlog(Blog blog,Long userId) {
        Optional<User> user= userRepo.findById(userId);
        if(user.isPresent()) {
            Blog blog1 = blogRepo.save(blog);
            user.get().getBlogs().add(blog1);
            userRepo.save(user.get());
            return blog1;
        } else
            throw new RuntimeException("User Not Found");
    }

    @Override
    public String deleteBlog(Long blogId, Long userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            Optional<Blog> blog = blogRepo.findById(blogId);
            if (blog.isPresent()) {
                user.get().getBlogs().remove(blog.get());
                userRepo.save(user.get());
                blogRepo.delete(blog.get());
                return "Successfully Deleted Blog";
            } else {
                return "Blog Not Found";
            }
        }
        return "User Not Found";
    }



    }
