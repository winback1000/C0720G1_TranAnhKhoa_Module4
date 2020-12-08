package com.codegym.blog_management.service.implement;

import com.codegym.blog_management.entity.Blog;
import com.codegym.blog_management.repository.IBlogRepository;
import com.codegym.blog_management.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> getAllBlog(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }


    @Override
    public Blog selectBlogById(int id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void saveBlog(Blog blog) {
        if(blog.getImage().equals("") && blog.getId() != null){
            blog.setImage(iBlogRepository.getOne(blog.getId()).getImage());
        }
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        iBlogRepository.deleteById(id);
    }


    @Override
    public Page<Blog> searchBlog(String searchData, Pageable pageable) {
        return iBlogRepository.findAllByTitleContainsOrContentContainsOrWriterContains(searchData,searchData,searchData,pageable);
    }

    @Override
    public Page<Blog> searchBlogByCatalogue(int id, Pageable pageable) {
        return iBlogRepository.findAllByCatalogue_Id(id,pageable);
    }
}
