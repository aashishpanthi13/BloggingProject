package com.example.blog.Repo;

import com.example.blog.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {
    @Query(nativeQuery = true, value = "SELECT b.* from user_blogs ub\n" +
            "left join blog b on b.id = ub.blogs_id\n" +
            "where ub.user_id = :id;")
    List<Blog> findBlogByUserId(@Param("id") Long id);

}
