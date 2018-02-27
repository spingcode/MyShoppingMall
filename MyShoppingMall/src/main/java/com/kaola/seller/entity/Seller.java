package com.kaola.seller.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Seller implements Serializable {
    private Integer id;

    private String sellerId;

    private String sellerAccount;

    private String sellerPassword;

    private String sellerMobile;

    private Byte deletedFlag;

    private Date createdOn;

    private static final long serialVersionUID = 1L;

    public Seller(String sellerAccount, String sellerPassword) {
        this.sellerAccount = sellerAccount;
        this.sellerPassword = sellerPassword;
    }

    public Seller() {
    }
}