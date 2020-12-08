package com.library.service;

import com.library.model.BorrowCard;
import com.library.model.TempBorrowCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowCardService {
    Page<BorrowCard> getAll(Pageable pageable);
    void lentBook(BorrowCard borrowCard);
    void returnBook(BorrowCard borrowCard);
    BorrowCard selectById(int id);

    void save(TempBorrowCard borrowCard, String[] arr);
}
