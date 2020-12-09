package com.codegym.blog_management.service.implement;

import com.codegym.blog_management.entity.Blog;
import com.codegym.blog_management.entity.Catalogue;
import com.codegym.blog_management.repository.IBlogRepository;
import com.codegym.blog_management.repository.ICatalogueRepository;
import com.codegym.blog_management.service.ICatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServiceImpl implements ICatalogueService {
    @Autowired
    private ICatalogueRepository iCatalogueRepository;
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Catalogue> getAllCatalogue() {
        return iCatalogueRepository.findAll();
    }

    @Override
    public void saveCatalogue(Catalogue catalogue) {
        iCatalogueRepository.save(catalogue);
    }

    @Override
    public Catalogue selectCatalogueById(int id) {
        return iCatalogueRepository.getOne(id);
    }

    @Override
    public void deleteCatalogue(int id) {
        iCatalogueRepository.deleteById(id);
    }

    @Override
    public Page<Catalogue> getCatalogueByPage(Pageable pageable) {
        return iCatalogueRepository.findAll(pageable);
    }

    public Page<Blog> getAllBlogOfCatalogue(int id,Pageable pageable) {
        return iBlogRepository.findAllByCatalogue_Id(id, pageable);
    }
}
