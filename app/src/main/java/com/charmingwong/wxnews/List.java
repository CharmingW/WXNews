/**
  * Copyright 2017 bejson.com 
  */
package com.charmingwong.wxnews;

import java.io.Serializable;

/**
 * Auto-generated: 2017-03-12 15:17:43
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class List  implements Serializable {

    private String id;
    private String title;
    private String source;
    private String firstImg;
    private String mark;
    private String url;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setSource(String source) {
         this.source = source;
     }
     public String getSource() {
         return source;
     }

    public void setFirstimg(String firstimg) {
         this.firstImg = firstimg;
     }
     public String getFirstimg() {
         return firstImg;
     }

    public void setMark(String mark) {
         this.mark = mark;
     }
     public String getMark() {
         return mark;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

}