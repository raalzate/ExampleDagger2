package com.example.raalzate.exampledagger2;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.example.raalzate.exampledagger2.di.components.ApiComponent;
import com.example.raalzate.exampledagger2.di.components.DaggerApiComponent;
import com.example.raalzate.exampledagger2.di.components.DaggerNetComponent;
import com.example.raalzate.exampledagger2.di.components.NetComponent;
import com.example.raalzate.exampledagger2.di.modules.GitHubModule;
import com.example.raalzate.exampledagger2.di.modules.AppModule;
import com.example.raalzate.exampledagger2.di.modules.NetModule;
import com.facebook.stetho.Stetho;


/**
 * Created by raul-alzate on 3/06/16.
 */
public class App extends Application {
    private NetComponent netComponent;
    private ApiComponent apiScopeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initORM();
        initStetho();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        apiScopeComponent = DaggerApiComponent.builder()
                .netComponent(netComponent)
                .gitHubModule(new GitHubModule())
                .build();
    }

    private void initStetho(){
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }

    private void initORM(){
        ActiveAndroid.initialize(this);
    }

    public static ApiComponent getComponent(Context context) {
        return ((App) context.getApplicationContext()).apiScopeComponent;
    }
}
