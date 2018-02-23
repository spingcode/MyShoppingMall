package com.kaola.seller.service.imp;/*
 *@Author:zouw
 *@Description:卖家的Service层
 *@Date:Created in 14:07 2018/1/31
 *@Modified By:
 */

import com.kaola.seller.entity.Seller;
import com.kaola.seller.mapper.SellerMapper;
import com.kaola.seller.service.SellerService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService{
    @Autowired
    private SellerMapper sellerMapper;
    @Override
    public int addSeller(Seller seller) {
        return sellerMapper.addSeller(seller);
    }

    @Override
    public int deleteSeller(Seller seller) {
        if (!StringUtils.isNullOrEmpty(seller.getSellerId()))
            return sellerMapper.deleteSellerBySellerId(seller.getSellerId());
        else if (!StringUtils.isNullOrEmpty(seller.getSellerAccount()))
            return sellerMapper.deleteSellerBySellerAccount(seller.getSellerAccount());
        else
            return sellerMapper.deleteSellerBySellerMobile(seller.getSellerMobile());
    }

    @Override
    public List<Seller> getAllSeller() {
        return sellerMapper.getAllSeller();
    }

    @Override
    public Seller getSellerBySellerId(String sellerId) {
        return sellerMapper.getSellerBySellerId(sellerId);
    }
}
