package com.kaola.seller.service.imp;/*
 *@Author:zouw
 *@Description:卖家的Service层
 *@Date:Created in 14:07 2018/1/31
 *@Modified By:
 */

import com.kaola.seller.service.SellerService;
import com.kaola.seller.entity.Seller;
import com.kaola.seller.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerMapper sellerMapper;
    @Override
    public int addSeller(Seller seller) {
        return sellerMapper.addSeller(seller);
    }

    @Override
    public Seller SellerLogin(Seller seller) {
        return sellerMapper.selectSellerBySellerNameAndPassword(seller);
    }


}
