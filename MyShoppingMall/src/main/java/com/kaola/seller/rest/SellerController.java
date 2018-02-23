package com.kaola.seller.rest;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 14:11 2018/1/31
 *@Modified By:
 */

import com.kaola.seller.entity.Seller;
import com.kaola.seller.service.SellerService;
import com.kaola.util.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping(value = "/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/registerSeller")
    public GeneralResponse<Integer> registerSeller(Seller seller)
    {
        seller.setSellerId(UUID.randomUUID().toString());
        int count = sellerService.addSeller(seller);
        return new GeneralResponse<Integer>().setValue(1);
    }
}
