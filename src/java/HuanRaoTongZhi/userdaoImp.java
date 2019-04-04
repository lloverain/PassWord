package HuanRaoTongZhi;

import org.springframework.stereotype.Repository;

/**
 * @author yangjiaying
 * @create 2019-03-30 上午3:42
 * @email 1296813487@qq.com
 */
@Repository("userdao")
public class userdaoImp implements userdao {
    @Override
    public void adduser() {
        System.out.println("1111");
    }

    @Override
    public void deleteuser() {
        System.out.println("2222");
    }
}
