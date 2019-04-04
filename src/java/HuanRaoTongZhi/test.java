package HuanRaoTongZhi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yangjiaying
 * @create 2019-03-30 上午3:54
 * @email 1296813487@qq.com
 */
public class test {
    public static void main(String[] args) {
        String xmlpath = "HuanRaoTongZhi/ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
        userdao userdao = (HuanRaoTongZhi.userdao) applicationContext.getBean("userdao");
        userdao.adduser();
        userdao.deleteuser();
    }
}
