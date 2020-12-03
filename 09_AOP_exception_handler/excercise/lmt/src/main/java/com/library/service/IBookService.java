package com.library.service;

import com.library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    void save(Book book);
    Book selectBookById(int id);
}
