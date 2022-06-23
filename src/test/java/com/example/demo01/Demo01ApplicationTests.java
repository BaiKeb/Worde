package com.example.demo01;

import com.example.demo01.entity.Book;
import com.example.demo01.service.BookService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@SpringBootTest
@SpringBootApplication
@MapperScan("com.example.demo01.mapper")
class Demo01ApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        List<Book> users = bookService.findAll();
        System.out.println(users);

    }

}
