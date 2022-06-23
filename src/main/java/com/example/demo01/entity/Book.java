package com.example.demo01.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName(value = "book")
public class Book {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String publish;
    private String authors;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
