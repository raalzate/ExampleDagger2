package com.example.raalzate.exampledagger2;

import android.app.Application;
import android.content.Context;

import com.example.raalzate.exampledagger2.di.components.DaggerGitHubComponent;
import com.example.raalzate.exampledagger2.di.components.DaggerNetComponent;
import com.example.raalzate.exampledagger2.di.components.GitHubComponent;
import com.example.raalzate.exampledagger2.di.components.NetComponent;
import com.example.raalzate.exampledagger2.di.modules.GitHubModule;
import com.example.raalzate.exampledagger2.di.modules.AppModule;
import com.example.raalzate.exampledagger2.di.modules.NetModule;

/**
 * Created by raul-alzate on 3/06/16.
 */
public class App extends Application {
    private NetComponent netComponent;
    private GitHubComponent apiGitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

       netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        apiGitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(netComponent)
                .gitHubModule(new GitHubModule())
                .build();
    }

    public static GitHubComponent getComponent(Context context) {
        return ((App) context.getApplicationContext()).apiGitHubComponent;
    }
}
