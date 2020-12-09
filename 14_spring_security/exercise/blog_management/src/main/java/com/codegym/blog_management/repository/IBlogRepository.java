package com.codegym.blog_management.repository;

import com.codegym.blog_management.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContainsOrContentContainsOrWriterContains(String searchData, String SearchData2,String SearchData3, Pageable pageable);
    Page<Blog> findAllByCatalogue_Id(int id, Pageable pageable);
}
