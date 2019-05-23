package com.yangjiaying.Servlet;
import com.yangjiaying.Interface.opration;
import com.yangjiaying.pojo.Passw;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-05-07 上午9:38
 * @email 1296813487@qq.com
 */
@Transactional
public class oprationImpl implements opration {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//    CustomerMapper customerMapper = context.getBean(CustomerMapper.class);
    SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");
    @Override
    public List<Passw> selectdata() {

        return sqlSession.selectList("rain.selectdata");
    }

    @Override
    public List<Passw> selectzhanghu(String zhanghu) {
        return sqlSession.selectList("rain.selectzhanghu",zhanghu);
    }

    @Override
    public List<Passw> selectpingtai(String pingtai) {
        return sqlSession.selectList("rain.selectpingtai",pingtai);
    }

    @Override
    public int insertdata(Passw passw) {
        return sqlSession.insert("rain.insertdata",passw);
    }

    @Override
    public int delectdata(Passw passw) {
        return sqlSession.delete("rain.delectdata",passw);
    }

    @Override
    public int androiddeletedate(Integer id) {
        int a = sqlSession.selectOne("rain.selectid",id);
        return sqlSession.delete("rain.androiddeletedata",a);
    }
}
