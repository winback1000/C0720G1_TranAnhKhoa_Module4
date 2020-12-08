package com.codegym.blog_management.service;

import com.codegym.blog_management.entity.Blog;
import com.codegym.blog_management.entity.Catalogue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICatalogueService {
    List<Catalogue> getAllCatalogue();
    void saveCatalogue(Catalogue catalogue);
    Catalogue selectCatalogueById(int id);
    void deleteCatalogue(int id);
    Page<Catalogue> getCatalogueByPage(Pageable pageable);
    Page<Blog> getAllBlogOfCatalogue( int id,Pageable pageable);
}
