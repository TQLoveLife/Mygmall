package com.atguigu.gmall.service;

import com.atguigu.gmall.beans.UmsMember;

import java.util.List;

public interface UserService {
    UmsMember getOne(String id);

    List<UmsMember> getAll();
}
