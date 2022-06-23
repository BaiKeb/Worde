package com.example.demo01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo01.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<Book> {
}
