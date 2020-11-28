package com.codegym.blog_management.service;

import com.codegym.blog_management.entity.Blog;
import com.codegym.blog_management.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> getAllBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog selectBlogById(int id) {
        return iBlogRepository.getOne(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        String image = iBlogRepository.getOne(blog.getId()).getImage();
        if(blog.getImage().equals("")){
            blog.setImage(image);
        }
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> searchBlog(String searchData) {
        return iBlogRepository.findAllByTitleContainsOrContentContains(searchData,searchData);
    }
}
