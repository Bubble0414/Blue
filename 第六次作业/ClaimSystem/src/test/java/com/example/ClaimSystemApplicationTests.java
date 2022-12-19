package com.example;

import com.example.dao.lostMapper;
import com.example.pojo.lost;
import com.example.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ClaimSystemApplicationTests {

    @Test
    void getLostMessage() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        lostMapper mapper = sqlSession.getMapper(lostMapper.class);
        List<lost> lostMessage = mapper.getLostMessage();
        for (lost lost : lostMessage) {
            System.out.println(lost);
        }
        sqlSession.close();
    }

    @Test
    void getLostMessageByType() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        lostMapper mapper = sqlSession.getMapper(lostMapper.class);
        List<lost> lostMessageByType = mapper.getLostMessageByType("钱包");
        for (lost lost : lostMessageByType) {
            System.out.println(lost);
        }
        sqlSession.close();
    }

    @Test
    void getLostMessageByDate() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        lostMapper mapper = sqlSession.getMapper(lostMapper.class);
        List<lost> lostMessageByDate = mapper.getLostMessageByDate("2022-8-1");
        for (lost lost : lostMessageByDate) {
            System.out.println(lost);
        }
        sqlSession.close();
    }

    @Test
    void addLost() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int i = sqlSession.getMapper(lostMapper.class).addLost(new lost(3, "钱包", "四教", "2022-12-18", "xxx", "xxx", 0));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void updateLost() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int i = sqlSession.getMapper(lostMapper.class).updateLost(new lost(3, "书包", "四教", "2022-12-18", "xxx", "xxx", 1));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void deleteLost() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        int i = sqlSession.getMapper(lostMapper.class).deleteLost(3);
        sqlSession.commit();
        sqlSession.close();
    }

}