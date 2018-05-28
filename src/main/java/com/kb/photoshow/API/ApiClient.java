package com.kb.photoshow.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kanbi on 22/05/2018.
 */
//URL="https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key=b5adf013f6be330db59e33070c658f55&gallery_id=72157643238009354&format=json&nojsoncallback=1";
//2e716c7d81c7cd25a6ef89e462c872f4
// https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key=2e716c7d81c7cd25a6ef89e462c872f4&gallery_id=72157643238009354&format=json&nojsoncallback=1
public class ApiClient {
    public static final String URL_START="https://api.flickr.com/services/";
    private static Retrofit retrofit= null;

    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(URL_START)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
