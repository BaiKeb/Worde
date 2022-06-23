package com.example.demo01.service.impl;

import com.example.demo01.entity.Book;
import com.example.demo01.mapper.BookMapper;
import com.example.demo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> findAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.selectById(id);
    }

    @Override
    public int insert(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int deleteById(Long id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public int updateById(Book book) {
        return bookMapper.updateById(book);
    }

}
