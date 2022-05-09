package org.example;

import com.java.user;
import com.mapper.usermapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class test {

    @Test
    public void test01() throws IOException {
        InputStream ins= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(ins);
        SqlSession session=ssf.openSession();
        SqlSession session1=ssf.openSession();
        usermapper umapp = session.getMapper(usermapper.class);//获取代理对象
        usermapper umapp2 = session1.getMapper(usermapper.class);//获取代理对象
        usermapper umapp1 = session1.getMapper(usermapper.class);//获取代理对象
        //session.selectList("");//这样是没有用到代理的,是直接取xml文件中找到sql语句的
//        List<user> list= umapp.getAll();//这边就是在调用接口中的方法,mybatis框架底层已经将功能代理出来了
//        for (user l:list){
//            System.out.println(l);
//        }
//        System.out.println("=================");
//        user u=umapp.getId(10);
//        System.out.println(u);
//        System.out.println("=================");
        Map map=new HashMap<>();
        map.put("name","username");
        map.put("val","a");
        List<user> list1=umapp.getmh(map);
        for(user li:list1){
            System.out.println(li);
        }
//user use=new user("iidd","123456");
//        int i=umapp.ins(use);
//        System.out.println(use.getId());
            //int i=umapp.upd(new user(8,"xixi","456"));
      //  System.out.println(i);
//        int i1=umapp.del(8);
     //   System.out.println(i1);
        System.out.println("*******************************************************************");
        Map map2=new HashMap<>();
        map2.put("name","username");
        map2.put("val","a");
        List<user> list2=umapp1.getmh(map2);
        for(user li:list2){
            System.out.println(li);
        }
        Map map3=new HashMap<>();
        map3.put("h1",1);
        map3.put("h2",5);

        List<user> list= umapp1.getido(map3);
        for (user li :list){
            System.out.println(li);
        }
        session.commit();
        session.close();
        session1.close();
    }
}
