package com.example.blog.Controller;

import com.example.blog.Dto.CommentDto;
import com.example.blog.Entity.Comment;
import com.example.blog.Service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")

@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/add")
    public ResponseEntity<String> addComment( @RequestBody Comment comment,
                                              @RequestParam("blogId") Long blogId,
                                              @RequestParam(name = "parentId", required = false) Long parentId,
                                              @RequestParam("userId") Long userId) {
        String comment1 = commentService.addComment(comment,blogId,parentId,userId);
        return new ResponseEntity<>(comment1,HttpStatus.OK);


    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteCommentById(@RequestParam("commentId") Long commentId) {
        String comment1 = commentService.deleteComment(commentId);
        return new ResponseEntity<>(comment1,HttpStatus.OK);
    }

    @GetMapping("getComment/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("id") Long commentId) {
        return new ResponseEntity<>(commentService.getComment(commentId),HttpStatus.OK);
    }


}
