package com.oddhov.boilerplate.data.network;

import com.oddhov.boilerplate.data.models.realm.DummyData;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by sammy on 06/09/17.
 */

public interface ApiService {
    @GET("test")
    Single<DummyData> getData();
}
