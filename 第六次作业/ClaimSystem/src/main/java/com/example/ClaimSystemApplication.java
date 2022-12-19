package com.example;

import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.service.Login.*;

@SpringBootApplication
public class ClaimSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClaimSystemApplication.class, args);
        List<User> userList = new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            userList = sqlSession.getMapper(UserMapper.class).getUserList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------校园失物招领登陆界面------------");
            System.out.println("欢迎来到校园失物招领系统");
            System.out.println("请选择操作: 1.登录  2.注册  3.忘记密码  4.退出系统");
            String choose = sc.next();
            switch (choose) {
                case "1": {
                    Login(userList);
                    break;
                }
                case "2": {
                    register(userList);
                    break;
                }
                case "3": {
                    forgetPasserword(userList);
                    break;
                }
                case "4": {
                    System.out.println("谢谢使用");
                    System.exit(0);
                }
                default:
                    System.out.println("没有这个选项");
            }
        }
    }
    }


