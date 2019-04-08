package pojo;

/**
 * @author yangjiaying
 * @create 2019-04-01 上午10:41
 * @email 1296813487@qq.com
 */
public class Passw {
    private String zhanghu;
    private String mima;
    private String pintai;

    @Override
    public String toString() {
        return "Passw{" +
                "zhanghu='" + zhanghu + '\'' +
                ", mima='" + mima + '\'' +
                ", pintai='" + pintai + '\'' +
                '}';
    }

    public String getPintai() {
        return pintai;
    }

    public void setPintai(String pintai) {
        this.pintai = pintai;
    }

    public String getZhanghu() {
        return zhanghu;
    }

    public void setZhanghu(String zhanghu) {
        this.zhanghu = zhanghu;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }
}
