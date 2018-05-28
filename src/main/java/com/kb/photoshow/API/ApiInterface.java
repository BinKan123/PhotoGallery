package com.kb.photoshow.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kanbi on 22/05/2018.
 */
//URL="https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos
// &api_key=bf895fb9241cd9cece54436cfdc5679b
// &gallery_id=72157667259442778
// &format=json
// &nojsoncallback=1";

public interface ApiInterface {
    @GET("rest/?")
    Call<PhotoResponse> Photos(
            @Query("method") String method,
            @Query("api_key") String key,
            @Query("gallery_id") String gallery_id,
            @Query("format") String format,
            @Query("nojsoncallback") int call_back
    );

}
