package com.example.raalzate.exampledagger2;

import android.app.Application;
import android.content.Context;

import com.example.raalzate.exampledagger2.component.DaggerDiComponent;
import com.example.raalzate.exampledagger2.component.DiComponent;

/**
 * Created by raul-alzate on 3/06/16.
 */
public class App extends Application {
    private DiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDiComponent.builder().build();
    }

    public static DiComponent getDiComponent(Context context) {
        return ((App) context.getApplicationContext()).component;
    }
}
