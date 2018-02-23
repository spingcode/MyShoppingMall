package com.kaola.commodit.mapper;

import com.kaola.commodit.entity.Commodit;

import java.util.List;

public interface CommoditMapper {
    int insertCommodit(Commodit commodit);
    int updateBycommoditId(Commodit commodit);
    int deleteCommodit(String commoditId);
    List<Commodit> selectCommodit();
    Commodit selectCommoditBycommoditId(String commoditId);
}