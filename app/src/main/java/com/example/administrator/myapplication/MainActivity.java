package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String base_path = "http://192.168.219.27:8080/";
    public static final String path = "Test/servlet/Test";

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.button)
    public void onClick() {
        Log.i("ln", "这是点击事件");
        baseMethon();
    }

    public void baseMethon() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(base_path).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        API api = retrofit.create(API.class);
//        getMethon(api);
        getUserModel(api);
    }

    public void getMethon(API api) {
        Observable<ResponseBody> observable = api.getMethon("lining");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", e.getMessage());
            }

            @Override
            public void onNext(ResponseBody ResponseBody) {
                Log.i("ln", "这是contenttype" + ResponseBody.contentType().toString());
                Log.i("ln", "这是contentlength" + ResponseBody.contentLength());
            }
        });
    }

    public void postMethon(API api) {

    }

    public void login(API api) {
        Observable<ResponseBody> observable = api.login("lining", "password");
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", e.getMessage());
            }

            @Override
            public void onNext(ResponseBody ResponseBody) {
                Log.i("ln", "这是contenttype" + ResponseBody.contentType().toString());
                Log.i("ln", "这是contentlength" + ResponseBody.contentLength());
            }
        });
    }

    public void getUserModel(API api) {
        Observable<userModel> observable = api.getUserModel();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<userModel>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", e.getMessage());
            }

            @Override
            public void onNext(userModel model) {
                Log.i("ln", model.toString());
            }
        });
    }

}
