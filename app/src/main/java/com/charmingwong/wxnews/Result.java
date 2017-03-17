/**
 * Copyright 2017 bejson.com
 */
package com.charmingwong.wxnews;

import java.io.Serializable;
import java.util.List;


/**
 * Auto-generated: 2017-03-12 15:17:43
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result  implements Serializable {

    private List<com.charmingwong.wxnews.List> list;
    private int totalPage;
    private int ps;
    private int pno;

    public void setList(List<com.charmingwong.wxnews.List> list) {
        this.list = list;
    }

    public List<com.charmingwong.wxnews.List> getList() {
        return list;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPs() {
        return ps;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getPno() {
        return pno;
    }

}