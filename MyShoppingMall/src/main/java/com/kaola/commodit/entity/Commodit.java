package com.kaola.commodit.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Commodit implements Serializable {
    private Integer id;

    private String commoditId;

    private String sellerId;

    private String title;

    private Float price;

    private String commoditImg;

    private String commoditAbstract;

    private String commoditText;

    private Integer number;

    private Integer sellerNumber;

    private Boolean deletedFlag;

    private Date createdOn;

    private static final long serialVersionUID = 1L;
}