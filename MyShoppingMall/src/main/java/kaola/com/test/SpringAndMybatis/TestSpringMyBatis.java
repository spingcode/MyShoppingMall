package kaola.com.test.SpringAndMybatis;/*
 *@Author:zouw
 *@Description:测试spring和mybatis
 *@Date:Created in 16:07 2018/1/28
 *@Modified By:
 */

import kaola.com.test.mapper.User;
import kaola.com.test.mapper.UserMapper;
import kaola.com.test.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMyBatis {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserMapper mapper = context.getBean(UserMapper.class);
        User user =   mapper.selectByPrimaryKey(1);
        System.out.println(user);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }
}
