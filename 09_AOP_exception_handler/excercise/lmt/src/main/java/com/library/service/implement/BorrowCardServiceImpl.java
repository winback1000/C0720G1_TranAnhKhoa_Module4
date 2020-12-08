package com.library.service.implement;

import com.library.model.Book;
import com.library.model.BorrowCard;
import com.library.model.Student;
import com.library.model.TempBorrowCard;
import com.library.repository.IBorrowCardRepository;
import com.library.repository.IStudentRepository;
import com.library.service.IBookService;
import com.library.service.IBorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowCardServiceImpl implements IBorrowCardService {

    @Autowired
    private IBorrowCardRepository iBorrowCardRepository;
    @Autowired
    private IStudentRepository iStudentRepository;
    @Autowired
    private IBookService iBookService;
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

    @Override
    public void save(TempBorrowCard borrowCard, String[] arr) {
        List<Book> borrowBookList = new ArrayList<>();
        BorrowCard confirmedCard = new BorrowCard();
        confirmedCard.setStudent(iStudentRepository.getOne(borrowCard.getIdStudent()));
        confirmedCard.setBorrowDate(LocalDate.now().toString());
        confirmedCard.setReturnDate(borrowCard.getReturnDate());
        for (String id : arr) {
            Book lentBook = iBookService.selectBookById(Integer.parseInt(id));
            lentBook.setQuantity(lentBook.getQuantity()-1);
            borrowBookList.add(lentBook);
        }
        confirmedCard.setBookList(borrowBookList);
        iBorrowCardRepository.save(confirmedCard);
    }
}
