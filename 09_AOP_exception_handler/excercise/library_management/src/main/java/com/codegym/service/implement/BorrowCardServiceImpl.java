package com.codegym.service.implement;

import com.codegym.model.BorrowCard;
import com.codegym.repository.IBorrowCardRepository;
import com.codegym.service.IBorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowCardServiceImpl implements IBorrowCardService {

    @Autowired
    private IBorrowCardRepository iBorrowCardRepository;
    @Override
    public Page<BorrowCard> getAll(Pageable pageable) {
        return iBorrowCardRepository.findAll(pageable);
    }

    @Override
    public void lentBook(BorrowCard borrowCard) {
        iBorrowCardRepository.save(borrowCard);
    }

    @Override
    public void returnBook(BorrowCard borrowCard) {
        iBorrowCardRepository.delete(borrowCard);
    }

    @Override
    public BorrowCard selectById(int id) {
        return iBorrowCardRepository.getOne(id);
    }
}
