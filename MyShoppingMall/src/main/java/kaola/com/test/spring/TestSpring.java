package kaola.com.test.spring;/*
 *@Author:zouw
 *@Description:测试spring
 *@Date:Created in 15:57 2018/1/28
 *@Modified By:
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.Date;

public class TestSpring {
    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Date data = context.getBean("data", Date.class);
        System.out.println(data);*/

        InputStream in = Object.class.getResourceAsStream("/springmvc.xml");
        System.out.println(in);
        InputStream in1 = Object.class.getResourceAsStream("/spring.xml");
        System.out.println(in1);
    }
}
