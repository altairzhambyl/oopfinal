package Notifications ;

import java.util.*;

import Users.User;

public class Message{
    private int messageId;
    private String messageContent;
    private User sender;
    private User reciever;
    private Date messageDate;

    public Message (){

    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageContent, sender, reciever, messageDate);
    }
    public Message(int id, String content, User sender, User reciever, Date date){
        this.messageId = id;
        this.messageContent = content;
        this.sender = sender;
        this.reciever = reciever;
        this.messageDate = date;
    }
    public Message(int id, String content, User sender, User reciever){
        this.messageId = id;
        if (content.equals(null)) {
        	System.err.print("BRO you cannot send empty message");
        	throw new NullPointerException("\n wtf man");
        }
        this.messageContent = content;
        this.sender = sender;
        this.reciever = reciever;
        this.messageDate = new Date();
    }

    public int getMessageId(){
        return this.messageId;
    }
    public void setMessageId(int id){
        this.messageId = id;
    }

    public String getMessageContent(){
        return this.messageContent;
    }
    public void setMessageContent(String content){
        this.messageContent = content;
    }
    public User getSender(){
        return this.sender;
    }
    public void setSender(User u){
        this.sender = u;
    }
    public User getReciever(){
        return this.reciever;
    }
    public void setReciever(User u){
        this.reciever = u;
    }
    public Date getMessageDate(){
        return this.messageDate;
    }
    public void setMessageDate(Date d){
        this.messageDate = d;
    }
    public void setMessageDate(){
        Date d = new Date();
        this.messageDate = d;
    }

    //write equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Message message = (Message) obj;
        return messageId == message.messageId &&
               Objects.equals(messageContent, message.messageContent) &&
               Objects.equals(sender, message.sender) &&
               Objects.equals(reciever, message.reciever) &&
               Objects.equals(messageDate, message.messageDate);
    }

    @Override
    public String toString(){
        return "Message ID: " + this.messageId + "\nMessage Content: " + this.messageContent + "\nSender: " + this.sender + "\nReciever: " + this.reciever + "\nMessage Date: " + this.messageDate;
    }
}
