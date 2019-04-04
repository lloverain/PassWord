package JDBC.Controller;

import JDBC.Dao.Passw;
import JDBC.Interface.CaoZuo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-04-02 上午1:20
 * @email 1296813487@qq.com
 */
public class Jdbc {
   public static CaoZuo initApplication(){
       String XmlPath = "JDBC/ApplicationContext.xml";
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext(XmlPath);
       CaoZuo caoZuo = (CaoZuo) applicationContext.getBean("caoZuo");
       return caoZuo;
   }
    public static int tianjia(Passw data){
       CaoZuo caoZuo = initApplication();
        int num = caoZuo.tianjia(data);
        if(num>0){
            return 1;
        }else{
            return 0;
        }
    }

    public static List<Passw> chaxun(){
        CaoZuo caoZuo = initApplication();
        List<Passw> list = caoZuo.chakan();
        return list;
    }

    public static int shanchu(Passw passw){
        CaoZuo caoZuo = initApplication();
        int num = caoZuo.shanchu(passw);
        if(num>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Test
    public void chuangbiao(){
        String XmlPath = "JDBC/ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(XmlPath);
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql = "CREATE TABLE user(id INT PRIMARY KEY auto_increment,zhanghu VARCHAR(50),mima VARCHAR(50),pintai VARCHAR(50))";
        jdbcTemplate.execute(sql);
        System.out.println("创建成功");
    }
}
