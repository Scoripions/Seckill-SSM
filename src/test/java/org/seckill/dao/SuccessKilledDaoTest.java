package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * 秒杀成功接口的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {


    @Resource
    private SuccessKilledDao successKilledDao;
    /**
     * 插入明细的测试
     * 因为在数据库中设置了联合主键 所以这里可以过滤掉重复提交的秒杀请求
     */
    @Test
    public void insertSuccessKilled() {
        Long id = 1000L;
        Long tel = 18279699658L;
        int i = successKilledDao.insertSuccessKilled(id, tel);
        System.out.println(i);
    }

    /**
     * 查询秒杀明细
     */
    @Test
    public void queryByIdWithSeckill() {
        Long id = 1000L;
        Long tel = 18279699658L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, tel);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}