package com.fenghaha.mymvp.presenter;

public interface MvpCallBack<T> {
    void onSuccess(T data);

    void onFailure(String msg);

    void onError();

    void onComplete();
}
