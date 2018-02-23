package com.kaola.seller.service;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 14:01 2018/1/31
 *@Modified By:
 */

import com.kaola.seller.entity.Seller;

public interface SellerService {
    public int addSeller(Seller seller);
    public Seller SellerLogin(Seller seller);
}
