import pojo.Passw;
import Interface.CaoZuo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangjiaying
 * @create 2019-04-01 上午10:42
 * @email 1296813487@qq.com
 */
public class test {
    public static void main(String[] args) {
        String XmlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(XmlPath);
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//        jdbcTemplate.execute("CREATE TABLE user(id INT PRIMARY KEY  auto_increment," +
//                "zhanghu VARCHAR(50)," +
//                "mima VARCHAR(50))");
//        System.out.println("创建成功");
        CaoZuo caoZuo = (CaoZuo) applicationContext.getBean("caoZuo");
        Passw passw = new Passw();
        passw.setZhanghu("rain1314520");
        passw.setMima("wazy1314520");
        int num = caoZuo.tianjia(passw);
        System.out.println(num);
        if(num>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}
