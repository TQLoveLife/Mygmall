package com.atguigu.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.user.mapper.UmsMemberMapper;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public UmsMember getOne(String id) {

       UmsMember umsMember = umsMemberMapper.selectByPrimaryKey(id);
        return umsMember;
    }

    @Override
    public List<UmsMember> getAll() {
        List<UmsMember> umsMembers = umsMemberMapper.selectAll();
        return umsMembers;
    }
}
