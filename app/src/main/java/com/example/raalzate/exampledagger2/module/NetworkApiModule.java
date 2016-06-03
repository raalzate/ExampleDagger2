package com.example.raalzate.exampledagger2.module;

import com.example.raalzate.exampledagger2.api.NetworkApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raul-alzate on 3/06/16.
 */
@Module
public class NetworkApiModule {
    @Provides
    @Singleton
    public NetworkApi getNetwork(){
        return new NetworkApi();
    }
}
