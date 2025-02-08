package org.example.dalaacademy;

public class User {
    private String userMail;
    private String userName;
    private String userPass;






    public User(String userName, String userMail, String userPass) {
        this.userName = userName;
        this.userMail = userMail;
        this.userPass = userPass;
    }

    public User() {

    }


    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getPassword(){
        return userPass;
    }

    public void setPassword(String userPass){
        this.userPass = userPass;
    }
    public String getUserMail(){
        return userMail;
    }
    public void setUserMail(String userMail){
        this.userMail = userMail;
    }



}
