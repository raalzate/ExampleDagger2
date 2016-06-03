package com.example.raalzate.exampledagger2.component;

import com.example.raalzate.exampledagger2.ui.MainActivity;
import com.example.raalzate.exampledagger2.module.NetworkApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raul-alzate on 3/06/16.
 */
@Singleton
@Component(modules = {NetworkApiModule.class})

public interface DiComponent {
    // to update the fields in your activities
    void inject(MainActivity activity);
}
