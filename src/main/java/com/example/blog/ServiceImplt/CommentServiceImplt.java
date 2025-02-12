package com.example.blog.ServiceImplt;

import com.example.blog.Dto.CommentDto;
import com.example.blog.Entity.Blog;
import com.example.blog.Entity.Comment;
import com.example.blog.Entity.User;
import com.example.blog.Mapper.CommentMapper;
import com.example.blog.Repo.BlogRepo;
import com.example.blog.Repo.CommentRepo;
import com.example.blog.Repo.UserRepo;
import com.example.blog.Service.CommentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CommentServiceImplt implements CommentService {
    private final UserRepo userRepo;
    private final CommentRepo commentRepo;
    private final BlogRepo blogRepo;
    private final CommentMapper commentMapper;

    @Override
    public String addComment(Comment comment, Long blogId, Long parentId,Long userId) {
        Optional<User>user=userRepo.findById(userId);
        Optional<Blog>blog=blogRepo.findById(blogId);
        if(blog.isPresent()) {
            if(user.isPresent()) {
                comment.setUser(user.get());
                if (parentId == null) {
                    // Adding a top-level comment
                    blog.get().getComments().add(comment); // cascade save happens with Blog
                    blogRepo.save(blog.get()); // Save the blog to persist the comment
                } else {
                    // Adding a reply to an existing comment
                    Optional<Comment> parentComment = commentRepo.findById(parentId);
                    if (parentComment.isPresent()) {
                        parentComment.get().getCommentReply().add(comment); // cascade save happens with Comment
                        commentRepo.save(parentComment.get()); // Save the parent comment, this will cascade and save the child (reply) comment
                    } else {
                        throw new RuntimeException("Comment not found"); // More specific exceptions might be used here
                    }
                }
            }else throw new RuntimeException("User not found");
        }else throw new RuntimeException("Blog not found");
        return "Comment added successfully";
    }

    @Override
    public String deleteComment(Long commentId) {
        Optional<Comment>comment=commentRepo.findById(commentId);
        if(comment.isPresent()) {
            commentRepo.delete(comment.get());
            return "Comment deleted successfully";
        }else throw new RuntimeException("Comment not found");

    }

    @Override
    public CommentDto getCommentById(Long commentId) {
        Comment comment=commentRepo.findById(commentId).get();
        System.out.println("comment:"+comment);
        return commentMapper.commentToCommentDto(comment);
    }

    @Override
    public List<CommentDto> getAll() {
        return commentMapper.repliesToRepliesDto(commentRepo.findAll());
    }

    @Override
    public List<Map<String, Object>> getByBlogId(Long blogId) {
        Optional<Blog>blog=blogRepo.findById(blogId);
        if(blog.isPresent()) {
            return commentRepo.findCommentByBlogId(blogId);
        }else {
            throw new RuntimeException("Blog not found");
        }
        }

    @Override
    public List<Map<String, Object>> getByUserId(Long userId) {
       Optional<User>user=userRepo.findById(userId);
       if(user.isPresent()) {
           return userRepo.findCommentsByUserId(userId);
       }else {
           throw new RuntimeException("User not found");
       }
    }

}



