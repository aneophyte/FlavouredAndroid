package com.sample.flavouredproject;

import android.support.annotation.NonNull;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Path;

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
        return new ApiService() {
            @Override
            public Call<ResponseBody> get(@Path("flavour") String flavour) {
                return new Call<ResponseBody>() {
                    @Override
                    public Response<ResponseBody> execute() throws IOException {
                        return getSuccessMockResponse();
                    }

                    @NonNull
                    private Response<ResponseBody> getSuccessMockResponse() {
                        ResponseBody response = ResponseBody.create(MediaType.parse("text/plain"), "This is the mock version.");
                        return Response.success(response);
                    }

                    @Override
                    public void enqueue(Callback<ResponseBody> callback) {
                        callback.onResponse(getSuccessMockResponse(), null);
                    }

                    @Override
                    public void cancel() {
                        throw new UnsupportedOperationException("Too lazy to implement.");
                    }

                    @Override
                    public Call<ResponseBody> clone() {
                        throw new UnsupportedOperationException("Does not compute.");
                    }
                };
            }
        };
    }

}
