package com.yangjiaying.controller;

import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet(name = "kebiao",value = "/kebiao")
public class kebiao extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String file = "/home/rain/kebiao.txt";
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        String data = result.toString();
        data = new String(data.getBytes("GBK"),"UTF8");
        PrintWriter out = response.getWriter();
        out.println(data);
        out.close();
    }
}
