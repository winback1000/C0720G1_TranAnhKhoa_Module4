package com.codegym.blog_management.repository;

import com.codegym.blog_management.entity.AppRole;
import com.codegym.blog_management.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<AppRole, Integer> {

@Query(value = "select ROLE_NAME from app_role join user_role on app_role.ROLE_ID = user_role.ROLE_ID join app_user on user_role.USER_ID = app_user.USER_ID where app_user.USER_ID = ?1", nativeQuery = true)
    List<String> getRoleNames(Long userId);
}
