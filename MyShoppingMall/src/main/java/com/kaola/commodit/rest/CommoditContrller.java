package com.kaola.commodit.rest;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 14:33 2018/2/23
 *@Modified By:
 */

import com.kaola.commodit.entity.Commodit;
import com.kaola.commodit.service.CommoditService;
import com.kaola.util.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/commodit")
public class CommoditContrller {
    @Autowired
    CommoditService commoditService;
    @RequestMapping(value = "/getAllCommodit")
    public ModelAndView getAllCommodit()
    {
        ModelAndView modelAndView = new ModelAndView();
        GeneralResponse<List<Commodit>> response = new GeneralResponse<>();
        List<Commodit> commoditList = commoditService.selectCommodit();
        response.setValue(commoditList);
        modelAndView.addObject("result",response);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/addCommodit")
    public ModelAndView addCommodit(Commodit commodit)
    {
        ModelAndView modelAndView = new ModelAndView();
        GeneralResponse<List<Commodit>> response = new GeneralResponse<>();
        commodit.setCommoditId(UUID.randomUUID().toString());
        commodit.setSellerId(UUID.randomUUID().toString());
        commoditService.insertCommodit(commodit);
        List<Commodit> commoditList = commoditService.selectCommodit();
        response.setValue(commoditList);
        modelAndView.addObject("result",response);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/deleteCommodit")
    public ModelAndView deleteCommodit(String commoditId)
    {
        ModelAndView modelAndView = new ModelAndView();
        GeneralResponse<List<Commodit>> response = new GeneralResponse<>();
        commoditService.deleteCommodit(commoditId);
        List<Commodit> commoditList = commoditService.selectCommodit();
        response.setValue(commoditList);
        modelAndView.addObject("result",response);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/modifyCommodit")
    public ModelAndView modifyCommodit(String commoditId)
    {
        ModelAndView modelAndView = new ModelAndView();
        GeneralResponse<Commodit> response = new GeneralResponse<>();
        Commodit commodit = commoditService.selectCommoditBycommoditId(commoditId);
        response.setValue(commodit);
        modelAndView.addObject("result",response);
        modelAndView.setViewName("commodit/modifyCommodit");
        return modelAndView;
    }
    @RequestMapping(value = "/updateCommodit")
    public ModelAndView updateCommodit(Commodit commodit)
    {
        ModelAndView modelAndView = new ModelAndView();
        GeneralResponse<List<Commodit>> response = new GeneralResponse<>();
        commoditService.updateBycommoditId(commodit);
        List<Commodit> commoditList = commoditService.selectCommodit();
        response.setValue(commoditList);
        modelAndView.addObject("result",response);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
