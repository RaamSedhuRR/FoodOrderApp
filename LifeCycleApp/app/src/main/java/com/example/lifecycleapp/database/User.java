package com.example.lifecycleapp.database;

public class User{
    public String id, name,age,phoneNumber;

    public User(String id, String name, String age, String phoneNumber){
        this.id= id;
        this.name= name;
        this.age= age;
        this.phoneNumber= phoneNumber;
    }



    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age=age;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }



}
