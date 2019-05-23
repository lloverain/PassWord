package com.yangjiaying.controller;

import com.yangjiaying.Interface.opration;
import com.yangjiaying.Servlet.oprationImpl;
import com.yangjiaying.pojo.Passw;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-05-21 下午4:28
 * @email 1296813487@qq.com
 */
@WebServlet(value = "/android",name = "android",loadOnStartup = 1)
public class Androidpass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        String opt = req.getParameter("opt");
        if("select".equals(opt)){
            select(req,resp);
        }
        if("write".equals(opt)){
            write(req,resp);
        }
        if("delete".equals(opt)){
            delete(req,resp);
        }
    }
    /*
    * 查询
    * */
    protected void select(HttpServletRequest req, HttpServletResponse resp){
        oprationImpl opration = new oprationImpl();
        List<Passw> list =  opration.selectdata();
        String json = JSONArray.fromObject(list).toString();
        System.out.println(json);
        try {
            PrintWriter writer = resp.getWriter();
            writer.write(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
* 插入
* */
    protected void write(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String zhanghu = req.getParameter("zhanghu");
        String mima = req.getParameter("mima");
        String pintai = req.getParameter("pintai");
        System.out.println(pintai+"111111111");
        Passw passw = new Passw();
        passw.setZhanghu(zhanghu);
        passw.setMima(mima);
        passw.setPintai(pintai);
        oprationImpl opration = new oprationImpl();
        int rain = opration.insertdata(passw);
        PrintWriter writer = resp.getWriter();
        if(rain==1){
            writer.write("1");
        }else {
            writer.write("0");
        }
        writer.flush();
        writer.close();
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String id = req.getParameter("iid");
        int i = Integer.parseInt(id);
        oprationImpl opration = new oprationImpl();
        int rain = opration.androiddeletedate(i);
        PrintWriter writer = resp.getWriter();
        if(rain == 1){
            writer.write("1");
        }else {
            writer.write("0");
        }
        writer.flush();
        writer.close();

    }
}
