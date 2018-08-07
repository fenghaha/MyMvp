package com.fenghaha.mymvp.model;

import android.util.Log;

import com.fenghaha.mymvp.Bean.Result;
import com.fenghaha.mymvp.Bean.Student;
import com.fenghaha.mymvp.presenter.MvpCallBack;
import com.fenghaha.mymvp.util.MyTextUtil;


import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginModel {
    public void login(String id, String password, MvpCallBack<Student> callBack) {
        if (MyTextUtil.isEmpty(id) || MyTextUtil.isEmpty(password)) {
            callBack.onFailure("请正确输入账号密码!");
        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://wx.idsbllp.cn/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            Api api = retrofit.create(Api.class);
            Observable<Result<Student>> observable = api.getStudent(id, password);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Result<Student>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Result<Student> studentResult) {
                            if (studentResult.getStatus() == 200) {
                                Log.d("RxJAVA使用", studentResult.getData().toString());
                                Student student = studentResult.getData();
                                callBack.onSuccess(student);
                            } else callBack.onFailure(studentResult.getInfo());
                        }

                        @Override
                        public void onError(Throwable e) {
                            callBack.onError();
                        }

                        @Override
                        public void onComplete() {
                            callBack.onComplete();
                        }
                    });
//            Call<Result<Student>> call = api.getStudent(id, password);
//            call.enqueue(new Callback<Result<Student>>() {
//                @Override
//                public void onResponse(Call<Result<Student>> call, Response<Result<Student>> response) {
//                    if (  response.body().getStatus() == 200) {
//                        Log.d("GSON转换", response.body().getData().toString());
//                        Student student = response.body().getData();
//                        callBack.onSuccess(student);
//                    }else callBack.onFailure(response.body().getInfo());
//                }
//
//                @Override
//                public void onFailure(Call<Result<Student>> call, Throwable t) {
//                    callBack.onError();
//                }
//            });
        }
    }
}
