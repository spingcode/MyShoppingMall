package com.kaola.commodit.service;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 12:09 2018/2/23
 *@Modified By:
 */

import com.kaola.commodit.entity.Commodit;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;
public class CommoditServiceTest {

    CommoditService commoditService;

    @Before
    public void init()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        commoditService = context.getBean(CommoditService.class);
    }
    @Test
    public void insertCommodit()
    {
        Commodit commodit = new Commodit();
        commodit.setCommoditId(UUID.randomUUID().toString());
        commodit.setSellerId(UUID.randomUUID().toString());
        commodit.setPrice(12.12f);
        commodit.setCommoditImg("a/b/c/d/f");
        commodit.setTitle("JAVA编程思想");
        commodit.setCommoditAbstract("JAVA书籍");
        commodit.setCommoditText("JAVA基础书籍，详细介绍JAVA相关内容");
        commodit.setNumber(20);
        commoditService.insertCommodit(commodit);
    }
    @Test
    public void selectCommodit()
    {
        String commoditId="e2a4ce66-076c-4848-aae7-b1ffdc660cdf";
        Commodit commodit = commoditService.selectCommoditBycommoditId(commoditId);
        System.out.println(commodit);
        List<Commodit> commodits = commoditService.selectCommodit();
        System.out.println(commodits);
    }
    @Test
    public void updataCommodit()
    {
        String commoditId="b23663ab-5d8e-4008-919f-247c30e83993";
        Commodit commodit = commoditService.selectCommoditBycommoditId(commoditId);
        if (commodit!=null) {
            commodit.setPrice(30.0f);
            commoditService.updateBycommoditId(commodit);
        }

    }
    @Test
    public void deleteCommodit()
    {
        String commoditId="e2a4ce66-076c-4848-aae7-b1ffdc660cdf";
        commoditService.deleteCommodit(commoditId);
    }
}
