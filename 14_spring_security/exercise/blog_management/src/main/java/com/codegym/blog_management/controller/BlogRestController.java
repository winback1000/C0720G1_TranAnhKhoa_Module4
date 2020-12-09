package com.codegym.blog_management.controller;

import com.codegym.blog_management.entity.Blog;
import com.codegym.blog_management.entity.Catalogue;
import com.codegym.blog_management.service.IBlogService;
import com.codegym.blog_management.service.ICatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiBlog")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICatalogueService iCatalogueService;

    @GetMapping("/blogList")
    public ResponseEntity<Page<Blog>> goHome(Pageable pageable) {
        Page<Blog> blogPage = iBlogService.getAllBlog(pageable);
        if(blogPage.getSize() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/catalogue")
    public ResponseEntity<List<Catalogue>> getCatalogueList() {
        return new ResponseEntity<>(iCatalogueService.getAllCatalogue(), HttpStatus.OK);
    }

    @GetMapping("/blogList/catalogue/{id}")
    public ResponseEntity<Page<Blog>> selectBlogById (@PathVariable int id, Pageable pageable) {
        return new ResponseEntity<>(iBlogService.searchBlogByCatalogue(id,pageable),HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById (@PathVariable int id) throws Exception{
        Blog result = iBlogService.selectBlogById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
