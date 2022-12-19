package com.example.service;

import com.example.dao.UserMapper;
import com.example.pojo.User;
import com.example.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Login {

    public static void forgetPasserword(List<User> userList) {
        System.out.println("***忘记密码***");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String userName = sc.next();
        boolean flag = contains(userList, userName);
        if (!flag) {
            System.out.println("当前用户" + userName + "未注册,请先注册");
            return;
        }
        System.out.println("请输入注册所用的手机号:");
        String phoneNumber = sc.next();
        int index = findIndex(userList, userName);
        User user = userList.get(index);
        if (!user.getPhoneNumber().equals(phoneNumber)) {
            System.out.println("手机号与用户不匹配");
            return;
        }
        String newPassword;
        while (true) {
            System.out.println("请输入新密码:");
            newPassword = sc.next();
            System.out.println("请再次输入新密码:");
            String againNewPassword = sc.next();
            if (newPassword.equals(againNewPassword)) {
                System.out.println("密码一致");
                break;
            } else {
                System.out.println("密码不一致,请重新输入");
                continue;
            }
        }
        user.setPassword(newPassword);
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int num = mapper.updateUser(new User(userName, newPassword));
        if (num > 0) {
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
        System.out.println("密码修改成功");
    }

    private static int findIndex(List<User> userList, String userName) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public static void register(List<User> userList) {
        System.out.println("***注册***");
        Scanner sc = new Scanner(System.in);
        String username;
        while (true) {
            System.out.println("请输入学号:");
            username = sc.next();
            boolean flag1 = checkUsername(username);
            if (flag1) {
                boolean flag2 = contains(userList, username);
                if (flag2) {
                    System.out.println("用户名" + username + "已存在,请重新输入");
                } else {
                    System.out.println("用户名" + username + "可用");
                    break;
                }
            } else {
                System.out.println("用户名格式不满足,请重新输入");
                continue;
            }
        }
        String password;
        while (true) {
            System.out.println("请输入密码:");
            password = sc.next();
            System.out.println("请再次输入密码:");
            String againPassword = sc.next();
            if (!password.equals(againPassword)) {
                System.out.println("两次密码输入不一致,请重新输入");
                continue;
            } else {
                System.out.println("密码设置成功");
                break;
            }
        }
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号码:");
            phoneNumber = sc.next();
            boolean flag = checkPhonenumber(userList, phoneNumber);
            if (flag) {
                System.out.println("手机号已注册,请重新输入");
                continue;
            } else {
                System.out.println("手机号未注册");
                break;
            }


        }
        System.out.println("请输入学院:");
        String institute = sc.next();
        System.out.println("请输入年级:");
        String grade = sc.next();
        System.out.println("请输入班级:");
        String class_ = sc.next();
        System.out.println("请输入姓名:");
        String name = sc.next();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int num = mapper.addUser(new User(username, institute, grade, class_, name, password, phoneNumber));
        if (num > 0) {
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
        System.out.println("注册成功");
    }

    private static boolean checkPhonenumber(List<User> userList, String phoneNumber) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            String phoneNumber1 = user.getPhoneNumber();
            if (phoneNumber1.equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private static boolean contains(List<User> userList, String username) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            String rightUsername = user.getName();
            if (rightUsername.equals(username)) {
                return true;
            }

        }
        return false;
    }

    private static boolean checkUsername(String username) {
        if (username.length() != 10) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static void Login(List<User> userList) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {

            userList = sqlSession.getMapper(UserMapper.class).getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println("***登录***");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入学号");
            String UserName = sc.next();
            boolean flag = contains(userList, UserName);
            if (!flag) {
                System.out.println("用户名" + UserName + "不存在,请先注册");
                return;
            }
            System.out.println("请输入密码");
            String Passport = sc.next();
            String rightCode = getCode();
            System.out.println("验证码是" + rightCode);
            System.out.println("请输入验证码:");
            String code = sc.next();
            User useInfo = new User(UserName, Passport, null);
            String rightPassport = checkUserInfo(userList, useInfo);
            if (Passport.equals(rightPassport) && code.equalsIgnoreCase(rightCode)) {
                System.out.println("登陆成功");
                ClaimSystem ss = new ClaimSystem();
                ss.startClaimSystem();
                break;
            } else {
                if (i == 2) {
                    System.out.println("登陆失败,账户已锁定");
                } else {
                    System.out.println("登陆失败,用户名或密码错误,还剩下" + (2 - i) + "次机会");
                }
            }

        }
    }

    private static String checkUserInfo(List<User> userList, User useInfo) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getStudent_no().equals(useInfo.getStudent_no())) {
                String rightPassport = user.getPassword();
                return rightPassport;
            }
        }
        return "";
    }

    public static String getCode() {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        int number = r.nextInt(10);
        sb.append(number);
        char[] chars = sb.toString().toCharArray();
        int randomIndex = r.nextInt(chars.length);
        char temp = chars[randomIndex];
        chars[randomIndex] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        return new String(chars);
    }

}

