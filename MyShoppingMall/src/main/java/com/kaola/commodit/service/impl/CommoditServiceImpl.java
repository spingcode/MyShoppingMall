package com.kaola.commodit.service.impl;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 13:16 2018/2/23
 *@Modified By:
 */

import com.kaola.commodit.entity.Commodit;
import com.kaola.commodit.mapper.CommoditMapper;
import com.kaola.commodit.service.CommoditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommoditServiceImpl implements CommoditService{
    @Autowired
    CommoditMapper commoditMapper;

    @Override
    public int insertCommodit(Commodit commodit) {
        return commoditMapper.insertCommodit(commodit);
    }

    @Override
    public int updateBycommoditId(Commodit commodit) {
        return commoditMapper.updateBycommoditId(commodit);
    }

    @Override
    public int deleteCommodit(String commoditId) {
        return commoditMapper.deleteCommodit(commoditId);
    }

    @Override
    public List<Commodit> selectCommodit() {
        return commoditMapper.selectCommodit();
    }

    @Override
    public Commodit selectCommoditBycommoditId(String commoditId) {
        return commoditMapper.selectCommoditBycommoditId(commoditId);
    }

    @Override
    public int getTotal() {
        return commoditMapper.getTotal();
    }

}
