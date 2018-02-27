package com.kaola.commodit.rest;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 14:33 2018/2/23
 *@Modified By:
 */

import com.kaola.commodit.entity.Commodit;
import com.kaola.commodit.service.CommoditService;
import com.kaola.util.GeneralResponse;
import com.kaola.util.RespFactory;
import com.kaola.util.ShoppingMallException;
import com.kaola.util.ValidatorUtils;
import com.kaola.util.ValidatorUtils.ValidatorResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/commodit")
public class CommoditContrller {
    private static final Log logger = LogFactory.getLog(CommoditContrller.class);
    @Autowired
    CommoditService commoditService;
    @RequestMapping(value = "/getAllCommodit")
    public ModelAndView getAllCommodit(HttpSession session)
    {
        logger.info("CommoditContrller.getAllCommodit start==========");
        ModelAndView modelAndView = new ModelAndView();
        GeneralResponse<List<Commodit>> response = new GeneralResponse<>();
        List<Commodit> commoditList = commoditService.selectCommodit();
        response.setValue(commoditList);
        modelAndView.addObject("result",response);
        modelAndView.setViewName("index");
        logger.info("CommoditContrller.getAllCommodit end=========="+commoditList);
        return modelAndView;
    }
    @RequestMapping(value = "/addCommodit")
    public ModelAndView addCommodit(@RequestParam(value = "file", required = false)MultipartFile file, Commodit commodit, HttpSession session)
    {
        logger.info("CommoditContrller.getAllCommodit start=========="+commodit);
        ValidatorResult validatorResult = ValidatorUtils.validateProperty(commodit, "title", "price",
                "commoditAbstract", "commoditText", "number");
        ModelAndView modelAndView = new ModelAndView();
        GeneralResponse<List<Commodit>> response = new GeneralResponse<>();
        if (validatorResult.isError())
        {
            modelAndView.addObject("result", RespFactory.buildFail(validatorResult.getErrorMsg()));
            modelAndView.setViewName("error");
            return modelAndView;
        }
        //把文件保存到项目上，把路径保存数据库
        commodit.setCommoditImg(UUID.randomUUID().toString()+"#"+file.getOriginalFilename());
        String parentPath = session.getServletContext().getRealPath("/img");
        File fileDest = new File(parentPath,commodit.getCommoditImg());
        try {
            file.transferTo(fileDest);
        } catch (IOException e) {
            logger.error("保存图片失败");
            modelAndView.addObject("result", RespFactory.buildFail("保存图片失败"));
            modelAndView.setViewName("error");
            return modelAndView;
        }
        //保存到数据库
        commodit.setCommoditId(UUID.randomUUID().toString());
        commodit.setSellerId(UUID.randomUUID().toString());
        commoditService.insertCommodit(commodit);
        modelAndView.setViewName("redirect:/");
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
        modelAndView.setViewName("redirect:/");
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
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @RequestMapping(value = "/showCommoditByCommodiyId")
    public ModelAndView showCommoditByCommodiyId(String commoditId)
    {
        logger.info("CommoditContrller.getAllCommodit start=========="+commoditId);
        ModelAndView modelAndView = new ModelAndView("error");
        ShoppingMallException.checkArgument(StringUtils.isNotEmpty(commoditId),"commoditId为空");
        Commodit commodit = commoditService.selectCommoditBycommoditId(commoditId);
        GeneralResponse<Commodit> response = new GeneralResponse<>();
        response.setValue(commodit);
        modelAndView.addObject("result",response);
        modelAndView.setViewName("commodit/showCommodit");
        return modelAndView;
    }
}
