package com.kaola.test.seller.service;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 14:23 2018/1/31
 *@Modified By:
 */

import com.kaola.seller.entity.Seller;
import com.kaola.seller.service.SellerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

public class SellerServiceTest {
    SellerService sellerService;
    @Before
    public void init()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        sellerService = context.getBean(SellerService.class);
    }
    @Test
    public void registSeller()
    {
        Seller seller = new Seller();
        seller.setSellerId(UUID.randomUUID().toString());
        seller.setSellerAccount("22696");
        seller.setSellerPassword("1516");
        seller.setSellerMobile("13182961081");
        seller.setDeletedFlag((byte)0);
        int count = sellerService.addSeller(seller);
        System.out.println(count);
    }
    @Test
    public void deleteSeller()
    {
        Seller seller = new Seller();
        //seller.setSellerId("eaf6332d-cc55-474d-96df-c69923e5aa47");
        //seller.setSellerAccount("22222");
        seller.setSellerMobile("111111111");
        sellerService.deleteSeller(seller);
    }
    @Test
    public void getAllSeller()
    {
        List<Seller> sellers = sellerService.getAllSeller();
        System.out.println(sellers);
    }
    @Test
    public void getSellerBySelerId()
    {
        Seller seller = sellerService.getSellerBySellerId("b03766ac-8cac-49bb-aac4-5cf246223f55");
        System.out.println(seller);
    }
}
