package com.library.repository;

import com.library.model.BorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowCardRepository extends JpaRepository<BorrowCard, Integer> {
}
