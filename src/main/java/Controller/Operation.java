package Controller;

import pojo.Passw;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-04-08 下午9:03
 * @email 1296813487@qq.com
 */
public class Operation {
//    private SqlSession initSql() throws IOException {
//
//        return sqlSession;
//    }

    public List<Passw> selectdata() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Passw> list = sqlSession.selectList("CustomerMapper.aaa");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
    public int insertdata(Passw passw) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int num = sqlSession.insert("CustomerMapper.insertdata",passw);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    public int deletedata(Passw passw) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int num = sqlSession.delete("CustomerMapper.deletedata",passw);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
