package com.kaola.user.rest;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 16:50 2018/2/27
 *@Modified By:
 */

import com.kaola.seller.entity.Seller;
import com.kaola.seller.service.SellerService;
import com.kaola.util.ShoppingMallException;
import com.kaola.util.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    SellerService sellerService;
    private static final Log logger = LogFactory.getLog(UserController.class);
    @RequestMapping(value = "/login")
    public ModelAndView login(String userName, String password, HttpSession session)
    {
        logger.info("UserController.login start==="+"userName:"+userName+" password:"+password);
        ModelAndView modelAndView = new ModelAndView("error");
        ShoppingMallException.checkArgument(StringUtils.isNotEmpty(userName),"用户名为空");
        ShoppingMallException.checkArgument(StringUtils.isNotEmpty(password),"密码为空");
        Seller seller = new Seller(userName,password);
        Seller sellerLogin = sellerService.SellerLogin(seller);
        if (sellerLogin!=null)
        {
            session.setAttribute("sellerUser",userName);
            session.setAttribute("buyerUser",null);
            session.setAttribute("loginStatus","sellerUser");
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/exit")
    public ModelAndView exit(HttpSession session)
    {
        logger.info("UserController.exit start===");
        ModelAndView modelAndView = new ModelAndView("error");
        session.setAttribute("sellerUser",null);
        session.setAttribute("buyerUser",null);
        session.setAttribute("loginStatus","visitor");
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
