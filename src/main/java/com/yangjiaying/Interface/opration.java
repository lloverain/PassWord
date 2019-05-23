package com.yangjiaying.Interface;

import com.yangjiaying.pojo.Passw;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-05-06 上午11:26
 * @email 1296813487@qq.com
 */
@Transactional
public interface opration {
    List<Passw> selectdata();//查询全部数据
    List<Passw> selectzhanghu(String zhanghu);//模糊查询账户
    List<Passw> selectpingtai(String pingtai);//模糊查询平台
    int insertdata(Passw passw);//插入数据
    int delectdata(Passw passw);//删除数据
    int androiddeletedate(Integer id);
}
