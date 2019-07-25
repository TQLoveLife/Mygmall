package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @ResponseBody
    @RequestMapping("getUserById")
    public UmsMember getUserById(String id){

       UmsMember umsMember = userService.getOne(id);

        return umsMember;
    }

    @ResponseBody
    @RequestMapping("getAllUsers")
    public List<UmsMember> getAllUsers(){

        List<UmsMember> umsMembers = userService.getAll();

        return umsMembers;
    }
}
