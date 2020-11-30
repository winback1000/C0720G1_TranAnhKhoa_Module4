package com.codegym.blog_management.service;

import com.codegym.blog_management.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IBlogService {
    Page<Blog> getAllBlog(Pageable pageable);
    Blog selectBlogById(int id);
    void saveBlog (Blog blog);
    void deleteBlog (int id);
    Page<Blog> searchBlog(String searchData, Pageable pageable);
}
