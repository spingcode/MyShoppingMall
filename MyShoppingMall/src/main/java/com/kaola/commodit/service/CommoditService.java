package com.kaola.commodit.service;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 13:14 2018/2/23
 *@Modified By:
 */

import com.kaola.commodit.entity.Commodit;

import java.util.List;

public interface CommoditService {
    int insertCommodit(Commodit commodit);
    int updateBycommoditId(Commodit commodit);
    int deleteCommodit(String commoditId);
    List<Commodit> selectCommodit();
    Commodit selectCommoditBycommoditId(String commoditId);
}
