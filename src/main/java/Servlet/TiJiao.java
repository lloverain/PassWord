package Servlet;

import Controller.*;
import org.springframework.core.annotation.Order;
import pojo.Passw;
import Interface.JieXi;
import net.sf.json.JSONArray;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-04-01 下午4:22
 * @email 1296813487@qq.com
 */
@WebServlet(name = "TiJiao",value = "/chuli",loadOnStartup = 1)
@Order(value = 1)
public class TiJiao extends HttpServlet {
    int pagesize= 2;//页面显示数
    List<Passw> list;//数据
    String leixing;//类型
    String lei;
    String data;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        int pagenum = 1;
        leixing = "show";
        Operation operation = new Operation();
        try {
                list = operation.selectdata();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fenye fenye = new fenye();
        PageBean pageBean = fenye.findAllsousuo(list,pagenum,pagesize);
        int end = pageBean.getEnd();
        int now = pageBean.getPageNum();
        List<Passw> showlist = pageBean.getList();
        int zongyeshu = pageBean.getTotalPage();
        config.getServletContext().setAttribute("pagesize",pagesize);
        config.getServletContext().setAttribute("now",now);
        config.getServletContext().setAttribute("end",end);
        config.getServletContext().setAttribute("data",showlist);
        config.getServletContext().setAttribute("leixing",leixing);
        config.getServletContext().setAttribute("zongyeshu",zongyeshu);
    }

    private JieXi jieXi = new JieXiImpl();
    private Operation caozuoSql = new Operation();//操作sql
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        resp.setHeader("Content-Type", "application/json;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
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
        if("show".equals(opt)){
            show(req,resp);
        }
        if("sousuo".equals(opt)){
            sousuo(req,resp);
        }
        if("changeshow".equals(opt)){
            changeshow(req,resp);
        }
        if("sousuoshow".equals(opt)){
            sousuoshow(req,resp);
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
        int num = caozuoSql.insertdata(datas);
        PrintWriter out = response.getWriter();
        out.print(num);
        out.close();
    }

    /**
     * 搜索全部信息
     * @param request
     * @param response
     * @throws SecurityException
     * @throws IOException
     */
    protected void chakan(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        List<Passw> list = caozuoSql.selectdata();
        JSONArray jsonArray = JSONArray.fromObject(list);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonArray.toString());
        printWriter.close();
    }

    /**
     * 删除
     * @param request
     * @param response
     * @throws SecurityException
     * @throws IOException
     */
    protected void shanchu(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        BufferedReader br = new BufferedReader(new
                InputStreamReader(request.getInputStream(), "UTF-8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String data = sb.toString();
        Passw use = jieXi.shanchu(data);
        int num = caozuoSql.deletedata(use);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(num);
        printWriter.close();
    }
    protected void show(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        int pagenum = Integer.parseInt(request.getParameter("pagenow"));
        leixing= "show";
        Operation operation = new Operation();
        list = operation.selectdata();
        try {
            fenye(pagenum,request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param pagenum
     * @param request
     * @param response
     * @throws SecurityException
     * @throws IOException
     * @throws ServletException
     */
    protected void fenye(int pagenum,HttpServletRequest request,HttpServletResponse response) throws SecurityException, IOException, ServletException {
        System.out.println("传来的类型"+leixing+"数据的个数"+list.size());
        HttpSession session = request.getSession();
        fenye fenye = new fenye();
        PageBean pageBean = fenye.findAllsousuo(list,pagenum,pagesize);
        int end = pageBean.getEnd();
        int now = pageBean.getPageNum();
        List<Passw> showlist = pageBean.getList();
        System.out.println("显示的数据个数"+showlist.size());
        int zongyeshu = pageBean.getTotalPage();
        if(showlist.size()==0){
            Passw passw = new Passw();
            passw.setZhanghu("没有数据");
            passw.setMima("没有数据");
            passw.setPintai("没有数据");
            showlist.add(passw);
            now = 1;
            zongyeshu = 0;
        }
        session.setAttribute("now",now);
        session.setAttribute("end",end);
        session.setAttribute("data",showlist);
        session.setAttribute("zongyeshu",zongyeshu);
        session.setAttribute("leixing",leixing);
        session.setAttribute("pagesize",pagesize);
        request.getRequestDispatcher("remenber.jsp").forward(request, response);
    }

    /**
     * 搜索
     * @param request
     * @param response
     * @throws SecurityException
     * @throws IOException
     */
    protected void sousuo(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        int pagenum = Integer.parseInt(request.getParameter("pagenow"));
         String l = request.getParameter("lei");//搜索的种类
         String d = request.getParameter("sousuoneirong");
        System.out.println(l+d);
        lei = new String(l.getBytes("iso-8859-1"),"utf8");
        data = new String(d.getBytes("iso-8859-1"),"utf8");
        System.out.println(lei+data);
        if("账户".equals(lei)){
            list = caozuoSql.sousuozhanghu(data);
        }
        if("平台".equals(lei)){
            list = caozuoSql.sousuopintai(data);
        }
        System.out.println("搜索出来的"+list.size());
        leixing = "sousuoshow";
        try {
            fenye(pagenum,request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
    protected void sousuoshow(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        int pagenum = Integer.parseInt(request.getParameter("pagenow"));
        pagesize = Integer.parseInt(request.getParameter("geshu"));
        leixing = "sousuoshow";
        try {
            fenye(pagenum,request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
    protected void changeshow(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
            pagesize = Integer.parseInt(request.getParameter("geshu"));
//            int pagenow = Integer.parseInt(request.getParameter("pagenow"));
            int pagenow =1;
        try {
            fenye(pagenow,request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

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
            List<Passw> list = caozuoSql.selectdata();
            JSONArray json = JSONArray.fromObject(list);
            PrintWriter out = response.getWriter();
            out.print(json.toString());
            out.close();
        }
    }

}
