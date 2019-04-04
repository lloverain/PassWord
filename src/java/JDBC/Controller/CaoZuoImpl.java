package JDBC.Controller;

import JDBC.Interface.CaoZuo;
import JDBC.Dao.Passw;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-04-01 上午10:53
 * @email 1296813487@qq.com
 */
public class CaoZuoImpl implements CaoZuo {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int tianjia(Passw passw) {
        String sql = "insert into user(zhanghu,mima,pintai) value (?,?,?)";
        Object[] objects = new Object[]{
                passw.getZhanghu(),
                passw.getMima(),
                passw.getPintai()
        };
        System.out.println(passw.getPintai());
        int num = this.jdbcTemplate.update(sql,objects);
        return num;
    }

    @Override
    public int gengxin(Passw passw) {
        String sql  = "update user set zhanghu=?,mima=? where zhanghu=? and mima=?";
        Object[] objects = new Object[]{
                passw.getZhanghu(),
                passw.getMima(),
                passw.getPintai()
        };
        int num = this.jdbcTemplate.update(sql,objects);
        return num;
    }

    @Override
    public int shanchu(Passw passw) {
        String sql = "delete from user where zhanghu=? and mima = ?";
        Object[] objects = new Object[]{
            passw.getZhanghu(),
            passw.getMima()
        };
        int num = this.jdbcTemplate.update(sql,objects);
        return num;
    }

    @Override
    public List<Passw> chakan() {
        String sql = "select * from user";
        RowMapper<Passw> rowMapper = new BeanPropertyRowMapper<>(Passw.class);
        List<Passw> list = this.jdbcTemplate.query(sql,rowMapper);
        return list;
    }
}
