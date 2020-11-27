package com.codegym.blog_management.repository;

import com.codegym.blog_management.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTitleContainsOrContentContains(String searchData,String SearchData2);
}
