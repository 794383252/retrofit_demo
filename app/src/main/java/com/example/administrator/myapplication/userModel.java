package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2016/8/20.
 */
public class userModel {
    private int id;
    private String username;
    private int age;

    public userModel(int id, String username, int age) {
        super();
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "userModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
