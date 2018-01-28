package kaola.com.test.mapper;/*
 *@Author:zouw
 *@Description:测试数据库的读写操作
 *@Date:Created in 15:28 2018/1/28
 *@Modified By:
 */

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.UUID;

public class TestUser {
    public static void main(String[] args) {
        String resource = "/config.xml";
        InputStream in = Object.class.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setName("zouw01");
        user.setAccount("2269607500");
        user.setPassword("1516");
        int count = mapper.insertSelective(user);
        session.commit();
        System.out.println(count);
        User us = mapper.selectByPrimaryKey(1);
        System.out.println(us);
    }
}
