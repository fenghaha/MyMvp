package com.fenghaha.mymvp.model;

import com.fenghaha.mymvp.Bean.Result;
import com.fenghaha.mymvp.Bean.Student;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by FengHaHa on2018/8/7 0007 23:44
 */
public interface Api {
    @FormUrlEncoded
    @POST("api/verify")
    Observable<Result<Student>> getStudent(@Field("stuNum") String id, @Field("idNum") String psw);

//    Call<Result<Student>> getStudent(@Field("stuNum") String id, @Field("idNum") String psw);
}
