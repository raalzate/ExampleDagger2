package com.example.raalzate.exampledagger2.di.components;

import android.content.SharedPreferences;

import com.example.raalzate.exampledagger2.di.modules.AppModule;
import com.example.raalzate.exampledagger2.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by raul-alzate on 3/06/16.
 */
@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
