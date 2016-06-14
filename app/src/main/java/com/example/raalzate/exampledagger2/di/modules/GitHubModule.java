package com.example.raalzate.exampledagger2.di.modules;

import com.example.raalzate.exampledagger2.api.GitHubApiInterface;
import com.example.raalzate.exampledagger2.di.scope.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by raul-alzate on 3/06/16.
 */
@Module
public class GitHubModule {

    @Provides
    @UserScope // needs to be consistent with the component scope
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubApiInterface.class);
    }
}
