package JDBC.Servlet;

import JDBC.Controller.Jdbc;
import JDBC.Controller.JieXiImpl;
import JDBC.Dao.Passw;
import JDBC.Interface.JieXi;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-04-01 下午4:22
 * @email 1296813487@qq.com
 */
@WebServlet(name = "TiJiao",value = "/chuli")
public class TiJiao extends HttpServlet {
    private JieXi jieXi = new JieXiImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        resp.setHeader("Content-Type", "application/json;charset=UTF-8");
        if("window".equals(opt)){
            windown(req,resp);
        }
        if("android".equals(opt)){
            android(req,resp);
        }
        if("chakan".equals(opt)){
            chakan(req,resp);
        }
        if("shanchu".equals(opt)){
            shanchu(req,resp);
        }
    }
    protected void windown(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        BufferedReader br = new BufferedReader(new
                InputStreamReader(request.getInputStream(), "UTF-8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        Passw datas = jieXi.jiexiJSON(data);
        int num = Jdbc.tianjia(datas);
        System.out.println("返回的是:"+num);
        PrintWriter out = response.getWriter();
        out.print(num);
        out.close();
    }

    protected void chakan(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        List<Passw> list = Jdbc.chaxun();
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.close();
    }

    protected void shanchu(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        BufferedReader br = new BufferedReader(new
                InputStreamReader(request.getInputStream(), "UTF-8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
//        System.out.println(data);
        Passw use = jieXi.shanchu(data);
        int num = Jdbc.shanchu(use);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(num);
        printWriter.close();
    }

    protected void android(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        BufferedReader br = new BufferedReader(new
                InputStreamReader(request.getInputStream(), "UTF-8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        System.out.println(data);
        String caozuo = jieXi.caozuo(data);
        System.out.println(caozuo);
        if("cha".equals(caozuo)){
            List<Passw> list = Jdbc.chaxun();
            JSONArray json = JSONArray.fromObject(list);
            PrintWriter out = response.getWriter();
            out.print(json.toString());
            out.close();
        }
    }
}
