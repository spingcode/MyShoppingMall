package com.kaola.commodit.entity;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Data
public class Commodit implements Serializable {
    private Integer id;

    private String commoditId;

    private String sellerId;

    @NotNull
    private String title;
    @NotNull
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