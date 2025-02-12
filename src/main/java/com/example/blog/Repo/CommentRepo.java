package com.example.blog.Repo;

import com.example.blog.Entity.Blog;
import com.example.blog.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Query(nativeQuery = true,value = "select id, comment_body from comment c where user_id =:id")
    List<Map<String, Object>> findCommentsByUser(@Param("id") Long id );

    List<Comment> id(Long id);
    @Query(nativeQuery = true, value = "SELECT c.* from blog_comments bc\n" +
            "left join comment c on c.id = bc.comments_id\n" +
            "where bc.blog_id = :id;")
    List<Map<String,Object>> findCommentByBlogId(@Param("id") Long id);
}
