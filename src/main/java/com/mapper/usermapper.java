package com.mapper;

import com.java.user;
import org.apache.ibatis.annotations.Param;

import java.io.InputStream;
import java.util.*;

public interface usermapper {
    List<user> getAll();

    //根据id进行查询
    user getId(int id);
    //模糊查询
    List<user> getmh(Map map);
    List<user> getido(Map map);
    //增加
    int ins(user us);
    //修改
    int upd(user us);
    //删除
    int del(int id);
}
