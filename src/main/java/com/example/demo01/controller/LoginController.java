package com.example.demo01.controller;

import com.example.demo01.api.CommonResult;
import com.example.demo01.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User vo) {
        System.out.println("用户："+vo.getUsername());
        System.out.println("密码："+vo.getPassword());

//        User vo1 = userService.login(vo);
        if (vo.getUsername().equals("admin") && vo.getPassword().equals("123456"))
//        if(vo1 != null)
            return CommonResult.success("admin");
        else
            return CommonResult.validateFailed();
    }
}
