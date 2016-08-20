package com.example.administrator.myapplication;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/17.
 */
public interface API {


    //@query查询参数就是一种最简单的向服务器传递数据的方式
    @GET("Test/servlet/Test")
    Observable<ResponseBody> getMethon(@Query("sort") String sort);

    @POST
    Observable<ResponseBody> postMethon(@Url String url);

    @POST("Test/servlet/Test?c=User&m=login")
    Observable<ResponseBody> login(@Field("phone") String phone, @Field("password") String password);

    @GET("Test/servlet/Test")
    Observable<userModel> getUserModel();

}
