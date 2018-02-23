package com.kaola.seller.service;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 14:01 2018/1/31
 *@Modified By:
 */

import com.kaola.seller.entity.Seller;

import java.util.List;

public interface SellerService {
    public int addSeller(Seller seller);
    public int deleteSeller(Seller seller);
    public List<Seller> getAllSeller();
    public Seller getSellerBySellerId(String sellerId);
}
