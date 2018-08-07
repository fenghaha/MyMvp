package com.fenghaha.mymvp.Bean;

/**
 * Created by FengHaHa on2018/8/8 0008 1:05
 */
public class Result<T> {
    int status;
    String info;
    T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
