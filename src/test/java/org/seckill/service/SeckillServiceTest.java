package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Service层的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    @Autowired
    private SeckillService seckillService;
    /**
     * 获取库存列表
     */
    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        System.out.println(seckillList);
    }

    @Test
    public void getById() {
        Long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        System.out.println(seckill);
    }

    @Test
    public void exportSeckillUrl() {
        Long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        System.out.println(exposer);
    }

    @Test
    public void excuteSeckill() {
        Long id = 1000L;
        long tel = 18279699648L;
        String md5 = "79a2e0d328a4a2ac9b8a96cdc6674787";
        SeckillExecution seckillExecution = seckillService.excuteSeckill(id, tel, md5);
        System.out.println(seckillExecution);
    }

    @Test
    public void excuteSeckillProcedure() {
        Long id = 1000L;
        long tel = 18279699638L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = seckillService.excuteSeckillProcedure(id, tel, md5);
            System.out.println(seckillExecution.getState());
        }
    }

}