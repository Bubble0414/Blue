package com.example.service;

import com.example.dao.lostMapper;
import com.example.pojo.lost;
import com.example.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.util.List;
import java.util.Scanner;

public class ClaimSystem {

    public void startClaimSystem() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到校园失物招领系统");
            System.out.println("请选择操作: 1.查询全部   2.根据物品查询  3.根据日期查询  4.添加  5.更新信息  6.删除  7.退出系统");
            String choose = sc.next();
            switch (choose) {
                case "1": {
                    SqlSession sqlSession = MybatisUtil.getSqlSession();
                    lostMapper mapper = sqlSession.getMapper(lostMapper.class);
                    List<lost> lostMessage = mapper.getLostMessage();
                    for (lost lost : lostMessage) {
                        System.out.println(lost);
                    }
                    sqlSession.close();
                    break;
                }
                case "2": {
                    System.out.println("请输入物品名称");
                    String name = sc.next();
                    SqlSession sqlSession = MybatisUtil.getSqlSession();
                    lostMapper mapper = sqlSession.getMapper(lostMapper.class);
                    List<lost> lostMessageByType = mapper.getLostMessageByType(name);
                    for (lost lost : lostMessageByType) {
                        System.out.println(lost);
                    }
                    sqlSession.close();
                    break;
                }
                case "3": {
                    System.out.println("请输入日期");
                    String date = sc.next();
                    SqlSession sqlSession = MybatisUtil.getSqlSession();
                    lostMapper mapper = sqlSession.getMapper(lostMapper.class);
                    List<lost> lostMessageByDate = mapper.getLostMessageByDate(date);
                    for (lost lost : lostMessageByDate) {
                        System.out.println(lost);
                    }
                    sqlSession.close();
                    break;
                }
                case "4": {
                    System.out.println("请输入物品名称");
                    String name = sc.next();
                    System.out.println("请输入丢失地点");
                    String place = sc.next();
                    System.out.println("请输入丢失日期");
                    String date = sc.next();
                    System.out.println("请输入领取位置");
                    String location = sc.next();
                    System.out.println("请输入物品描述");
                    String description = sc.next();
                    SqlSession sqlSession = MybatisUtil.getSqlSession();
                    int i = sqlSession.getMapper(lostMapper.class).addLost(new lost(name, place, date, location, description, 0));
                    sqlSession.commit();
                    sqlSession.close();
                    break;
                }
                case "5": {
                    System.out.println("请输入物品id");
                    int id = sc.nextInt();
                    System.out.println("请输入物品名称");
                    String name = sc.next();
                    System.out.println("请输入丢失地点");
                    String place = sc.next();
                    System.out.println("请输入丢失日期");
                    String date = sc.next();
                    System.out.println("请输入领取位置");
                    String location = sc.next();
                    System.out.println("请输入物品描述");
                    String description = sc.next();
                    SqlSession sqlSession = MybatisUtil.getSqlSession();
                    int i = sqlSession.getMapper(lostMapper.class).addLost(new lost(id, name, place, date, location, description, 0));
                    sqlSession.commit();
                    sqlSession.close();
                    break;
                }
                case "6": {
                    System.out.println("请输入物品id");
                    int id = sc.nextInt();
                    SqlSession sqlSession = MybatisUtil.getSqlSession();
                    int i = sqlSession.getMapper(lostMapper.class).deleteLost(id);
                    sqlSession.commit();
                    sqlSession.close();
                }
                case "7": {
                    System.out.println("谢谢使用");
                    System.exit(0);
                }
                default:
                    System.out.println("没有这个选项");
            }
        }
    }
}
