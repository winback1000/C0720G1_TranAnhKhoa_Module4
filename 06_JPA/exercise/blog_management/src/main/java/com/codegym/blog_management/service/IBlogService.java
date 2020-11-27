package com.codegym.blog_management.service;

import com.codegym.blog_management.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();
    Blog selectBlogById(int id);
    void saveBlog (Blog blog);
    void deleteBlog (int id);
    List<Blog> searchBlog(String searchData);
}
