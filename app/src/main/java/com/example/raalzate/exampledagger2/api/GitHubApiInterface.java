package com.example.raalzate.exampledagger2.api;

import com.example.raalzate.exampledagger2.model.Repository;
import com.example.raalzate.exampledagger2.model.RepositoryPOJO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by raul-alzate on 3/06/16.
 */
public interface GitHubApiInterface {
    @GET("/users/{users}/repos")
    Call<ArrayList<RepositoryPOJO>> getRepository(@Path("users") String users);
}
