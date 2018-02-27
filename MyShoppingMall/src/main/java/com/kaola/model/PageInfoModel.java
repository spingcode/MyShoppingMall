package com.kaola.model;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 19:49 2018/2/25
 *@Modified By:
 */

import lombok.Data;

import java.util.List;
@Data
public class PageInfoModel<T> {
    private List<T> context;
    private int total;
    private int pageNum;
    private int pageSize;
    private int beforePage;
    private int afterPage;
    private int maxPage;

    public PageInfoModel(int total, int pageSize, int pageNum, List<T> context) {
        this.total=total;
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        maxPage = (int) (Math.ceil(((double) total)/pageSize));
        beforePage=pageNum-1;
        afterPage=pageNum+1;
        if (beforePage<1)
            beforePage=1;
        if (afterPage>maxPage)
            afterPage=maxPage;
        this.context=context;
    }

    public static void main(String[] args) {
        PageInfoModel<String> p = new PageInfoModel<>(11,1,null);
        System.out.println(p.maxPage);
    }
    public PageInfoModel(int total,int pageNum,List<T> context){
        this(total,10,pageNum,context);
    }
}
