package com.codegym.blog_management.repository;

import com.codegym.blog_management.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<AppUser,Integer> {

    AppUser findByUserName(String userName);
}
