package com.example.raalzate.exampledagger2.di.components;

import com.example.raalzate.exampledagger2.di.modules.GitHubModule;
import com.example.raalzate.exampledagger2.di.scope.UserScope;
import com.example.raalzate.exampledagger2.view.MainActivity;

import dagger.Component;

/**
 * Created by raul-alzate on 3/06/16.
 */

@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface ApiComponent {
    void inject(MainActivity activity);
}
