package com.example.blog.Repo;

import com.example.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Long id(Long id);
    @Query(nativeQuery = true,value = "select id,comment_body from comment c where user_id = id")
    List<Map<String, Object>> findCommentsByUserId(@Param("id") Long id );
}
