package com.fenghaha.mymvp.Bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FengHaHa on2018/8/8 0008 1:17
 */
public class Student {
    private String stuNum;
    private String name;
    private String college;
    @SerializedName("class")
    private String clazz;
    private String classNum;
    private String gender;
    private String major;
    private String grade;
    private String idNum;

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    @Override
    public String toString() {
        return "User { " +
                "stuNum='" + stuNum + '\'' +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", classX='" + clazz + '\'' +
                ", classNum='" + classNum + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", idNum='" + idNum + '\'' +
                '}';
    }
}
