package com.example.blog.Controller;

import com.example.blog.Entity.Blog;
import com.example.blog.Service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private BlogService blogService;
    @PostMapping("/add")
    public ResponseEntity<Blog> add(@RequestBody Blog blog, @RequestParam("userId") Long userId) {
        Blog blog1 = blogService.addBlog(blog,userId);
        return new ResponseEntity<>(blog1, HttpStatus.OK);

    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam("id") Long id, @RequestParam("userId") Long userId) {
        String result = blogService.deleteBlog(id,userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
