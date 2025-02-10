package com.example.studentmanagementsystem;

public class Student {

    private  final int _id;
    private final String name;
    private final String password;

    Student(int _id,String name,String password){
        this._id = _id;
        this.name = name;
        this.password = password;
    }

    public int getId(){
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getPassword(){
        return password;
    }
}
