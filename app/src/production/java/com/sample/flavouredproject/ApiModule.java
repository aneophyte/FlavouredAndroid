package com.sample.flavouredproject;

import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by razzle on 12/18/15.
 */

@Module
public class ApiModule {

    private final String baseUrl;

    public ApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    public ApiService provideApiService() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        builder.client(new OkHttpClient());
        return builder.build().create(ApiService.class);
    }

}
