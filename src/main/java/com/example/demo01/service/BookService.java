package com.example.demo01.service;

import com.example.demo01.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();
    public Book findById(Long id);
    public int insert(Book book);
    public int deleteById(Long id);
    public int updateById(Book book);

}
