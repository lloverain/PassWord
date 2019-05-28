package com.yangjiaying.Servlet;

import com.yangjiaying.Interface.Verification;
import com.yangjiaying.pojo.user;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VerificationImpl implements Verification {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");
    @Override
    public int login(user user) {

        return sqlSession.selectOne("rain.login",user);
    }
}
