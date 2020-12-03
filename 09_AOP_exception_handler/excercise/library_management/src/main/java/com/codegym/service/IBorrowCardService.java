package com.codegym.service;

import com.codegym.model.BorrowCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowCardService {
    Page<BorrowCard> getAll(Pageable pageable);
    void lentBook(BorrowCard borrowCard);
    void returnBook(BorrowCard borrowCard);
    BorrowCard selectById(int id);

}
