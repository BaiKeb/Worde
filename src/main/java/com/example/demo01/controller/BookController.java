package com.example.demo01.controller;

import com.example.demo01.entity.Book;
import com.example.demo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/booklist")
    public List<Book> booklist(){
        return bookService.findAll();
    }

    @RequestMapping("/addbook")
    public int addbook(@RequestBody Book book){
        return bookService.insert(book);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable("id") Long id){
        Integer result = 0;
        result = bookService.deleteById(id);
        //删除成功则返回受影响的行数
        return result;
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Long id){
        return bookService.findById(id);
    }

    @PutMapping("/updateById")
    public int updateById(@RequestBody Book book){
        //返回修改的条数
        return bookService.updateById(book);
    }

}
