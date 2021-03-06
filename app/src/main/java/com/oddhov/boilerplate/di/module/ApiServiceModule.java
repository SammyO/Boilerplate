package com.oddhov.boilerplate.di.module;

import com.oddhov.boilerplate.BuildConfig;
import com.oddhov.boilerplate.data.network.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sammy on 07/09/17.
 */

@Module
public class ApiServiceModule {

    public ApiServiceModule() {}

    @Singleton
    @Provides
    public ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                     GsonConverterFactory gsonConverterFactory,
                                     OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient);
        return builder.build();
    }

    @Singleton
    @Provides
    public RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    public GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        if (BuildConfig.DEBUG) {
            return new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(ApiService.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .build();
        } else {
            return new OkHttpClient.Builder()
                    .connectTimeout(ApiService.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .build();
        }
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
