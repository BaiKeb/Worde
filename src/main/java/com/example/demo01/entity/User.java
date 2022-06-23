package com.example.demo01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Eli Shaw
 * @Date: 2019-11-14 11:31:45
 * @Description：
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName(value = "t_user")
public class User {

    private int id;
    private String username;
    private String password;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
