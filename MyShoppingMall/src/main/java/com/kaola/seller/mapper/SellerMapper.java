package com.kaola.seller.mapper;

import com.kaola.seller.entity.Seller;

public interface SellerMapper {
    public int addSeller(Seller seller);
    public Seller selectSellerBySellerNameAndPassword(Seller seller);
}