package com.kaola.seller.mapper;

import com.kaola.seller.entity.Seller;

import java.util.List;

public interface SellerMapper {
    public int addSeller(Seller seller);
    public int deleteSellerBySellerId(String sellerId);
    public int deleteSellerBySellerAccount(String sellerAccount);
    public int deleteSellerBySellerMobile(String sellerMobile);
    public List<Seller> getAllSeller();
    public Seller getSellerBySellerId(String sellerId);
}