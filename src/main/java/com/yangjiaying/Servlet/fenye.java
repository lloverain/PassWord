package com.yangjiaying.Servlet;

import com.yangjiaying.pojo.Passw;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjiaying
 * @create 2019-04-24 上午11:54
 * @email 1296813487@qq.com
 */
public class fenye {
    public PageBean<Passw> findAllsousuo(List<Passw> list,int pageNum,int pageSize){
        int totalRecord = list.size();
        PageBean pageBean = new PageBean(pageNum,pageSize,totalRecord);
        int startIndex = pageBean.getStartIndex();
        pageBean.setList(findsousuo(list,startIndex,pageSize));
        return pageBean;
    }

    public List<Passw> findsousuo(List<Passw> list,int startIndex, int pageSize){
        System.out.println(list.size()+"------"+startIndex+"---------"+pageSize);
        List<Passw> showlist = new ArrayList<Passw>();
        int num = (list.size()-startIndex);
        if(num<=pageSize ){
            for(int i=0;i<num;i++,startIndex++){
                Passw passw = new Passw();
                passw = list.get(startIndex);
                showlist.add(passw);
            }
        }else{
            for(int i=0;i<pageSize;startIndex++,i++){
                Passw passw = new Passw();
                passw = list.get(startIndex);
                showlist.add(passw);
            }
        }


        return showlist;
    }

}
