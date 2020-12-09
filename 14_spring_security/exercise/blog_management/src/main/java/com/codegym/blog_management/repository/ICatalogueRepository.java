package com.codegym.blog_management.repository;

import com.codegym.blog_management.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogueRepository extends JpaRepository<Catalogue, Integer> {
}
