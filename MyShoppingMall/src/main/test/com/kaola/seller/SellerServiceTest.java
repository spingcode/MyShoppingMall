package com.kaola.seller;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 14:06 2018/2/23
 *@Modified By:
 */

import com.kaola.seller.service.SellerService;
import com.kaola.seller.entity.Seller;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        seller.setSellerAccount("seller");
        seller.setSellerPassword("relles");
        seller.setSellerMobile("13182961081");
        seller.setDeletedFlag((byte)0);
        int count = sellerService.addSeller(seller);
        System.out.println(count);
    }
    @Test
    public void Sellerlogin()
    {
        Seller seller = new Seller();
        seller.setSellerAccount("seller");
        seller.setSellerPassword("relles");
        Seller sellerLogin = sellerService.SellerLogin(seller);
        System.out.println(sellerLogin);
    }
}
