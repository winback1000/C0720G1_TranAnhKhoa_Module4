package com.furama.repository;

import com.furama.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "select role_name from role join account_role on role.id = account_role.role_id join user_account on account_role.account_id = user_account.id where user_account.id = ?1", nativeQuery = true)
    List<String> getRoleNames(Integer id);
}
