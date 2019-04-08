package Controller;

import pojo.Passw;
import Interface.JieXi;
import net.sf.json.JSONObject;

/**
 * @author yangjiaying
 * @create 2019-04-02 上午1:17
 * @email 1296813487@qq.com
 */
public class JieXiImpl implements JieXi {
    @Override
    public Passw jiexiJSON(String data) {
        Passw passw = new Passw();
        JSONObject object = JSONObject.fromObject(data);
        String zhanghu = object.getString("zhanghu");
        String mima = object.getString("mima");
        String pintai = object.getString("pintai");
        passw.setZhanghu(zhanghu);
        passw.setMima(mima);
        passw.setPintai(pintai);
        return passw;
    }

    @Override
    public String caozuo(String data) {
        JSONObject jsonObject  = JSONObject.fromObject(data);
        String caozuo = jsonObject.getString("caozuo");
        return caozuo;
    }

    @Override
    public Passw shanchu(String data) {
        JSONObject jsonObject =  JSONObject.fromObject(data);
        Passw passw = new Passw();
        passw.setZhanghu(jsonObject.getString("zhanghu"));
        passw.setMima(jsonObject.getString("mima"));
        return passw;
    }
}
