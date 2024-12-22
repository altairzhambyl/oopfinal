package Notifications ;

import java.util.*;

public class News {
    private int newsId;
    private String newsHeadline;
    private String newsContent;
    private Date newsDate;
    private String newsAuthor; 

    public News (int id, String headline, String content, Date date, String author){
        this.newsId = id;
        this.newsHeadline = headline;
        this.newsContent = content;
        this.newsAuthor = author;
        Date d = new Date();
        this.newsDate = d;
    }
    public News (){
    }
    public News (int id, String headline, String content, String author){
        this.newsId = id;
        this.newsHeadline = headline;
        this.newsContent = content;
        this.newsAuthor = author;
        Date d = new Date();
        this.newsDate = d;
    } 

    public int getNewsId(){
        return this.newsId;
    }
    public void setNewsId(int id){
    this.newsId = id;
    }
    public String getNewsHeadline(){
        return this.newsHeadline;
    }
    public void setNewsHeadline(String headline){
        this.newsHeadline = headline;
    }
    public String getNewsContent(){
     return this.newsContent;
    }
    public void setNewsContent(String content){
        this.newsContent = content;
    }
    public Date getNewsDate(){
         return this.newsDate;
    }
    public void setNewsDate(Date d){
         this.newsDate = d;
    }
    public void setNewsDate(){
         Date d = new Date();
         this.newsDate = d;
    }
    public String getNewsAuthor(){
         return this.newsAuthor;
    }
    public void setNewsAuthor(String author){
         this.newsAuthor = author;
    }
    @Override
    public int hashCode() {
        return Objects.hash(newsId, newsHeadline, newsContent, newsDate, newsAuthor);
    }
    //equals and tostring
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof News)){
            return false;
        }
        News n = (News) o;
        return newsId == n.newsId && newsHeadline.equals(n.newsHeadline) && newsContent.equals(n.newsContent) && newsDate.equals(n.newsDate) && newsAuthor.equals(n.newsAuthor);
    }
    @Override
    public String toString(){
        return "News ID: " + newsId + "\nHeadline: " + newsHeadline + "\nContent: " + newsContent + "\nDate: " + newsDate + "\nAuthor: " + newsAuthor;
    }
}