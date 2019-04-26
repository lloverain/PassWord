package Interface;

import pojo.Passw;

import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-04-01 上午10:52
 * @email 1296813487@qq.com
 */
public interface CaoZuo {
    public int tianjia(Passw passw);
    public int gengxin(Passw passw);
    public int shanchu(Passw passw);
    public List<Passw> chakan();
    public List<Passw> sousuo();
}
