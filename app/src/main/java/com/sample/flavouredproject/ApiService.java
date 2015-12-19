package com.sample.flavouredproject;

import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by razzle on 12/18/15.
 */
public interface ApiService {

    @GET("{flavour}.txt")
    Call<ResponseBody> get(@Path("flavour") String flavour);

}
