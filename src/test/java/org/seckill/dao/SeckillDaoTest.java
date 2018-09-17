package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 库存接口的测试类
 * 配置Spring与Junit进行整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    /**
     * 减库存的测试
     */
    @Test
    public void reduceNumber() {
        Long id = 1000L;
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        // 模拟两天后的秒杀
        instance.set(Calendar.DATE,instance.get(Calendar.DATE)+2);
        int i = seckillDao.reduceNumber(id, instance.getTime());
        System.out.println(i);
    }

    /**
     * 通过Id进行查询
     */
    @Test
    public void queryById() {
        Long id = 1000L;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    /**
     * 根据偏移量进行查询
     */
    @Test
    public void queryAll() {
        List<Seckill> seckillList = seckillDao.queryAll(0, 10);
        for (Seckill seckill: seckillList
             ) {
            System.out.println(seckill);
        }
    }
}