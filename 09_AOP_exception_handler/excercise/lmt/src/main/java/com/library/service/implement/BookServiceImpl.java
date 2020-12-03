package com.library.service.implement;

import com.library.model.Book;
import com.library.repository.IBookRepository;
import com.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> getAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book selectBookById(int id) {
        return iBookRepository.getOne(id);
    }
}
