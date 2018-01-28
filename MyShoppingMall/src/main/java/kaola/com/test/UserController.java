package kaola.com.test;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 17:06 2018/1/28
 *@Modified By:
 */

import kaola.com.test.mapper.User;
import kaola.com.test.mapper.UserMapper;
import kaola.com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

public class UserController implements Controller{

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /*
        * 测试springmvc
        * */
       /* System.out.println("Before");
        System.out.println(request);
        System.out.println(response);
        System.out.println("After");*/
       /*
       * 测试ssm框架
       * */
       /* System.out.println(userMapper);
        System.out.println(date);
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setName("zouw01");
        user.setAccount("2269607500");
        user.setPassword("1516");
        userMapper.insertSelective(user);
        User user1 = userMapper.selectByPrimaryKey(4);
        System.out.println(user1);*/


        System.out.println(userService);
        return new ModelAndView("index");
    }

}
