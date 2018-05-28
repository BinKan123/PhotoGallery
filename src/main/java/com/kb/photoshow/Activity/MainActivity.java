package com.kb.photoshow.Activity;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kb.photoshow.API.ApiClient;
import com.kb.photoshow.API.ApiInterface;
import com.kb.photoshow.API.PhotoResponse;
import com.kb.photoshow.Adapter.PhotoAdapter;

import com.kb.photoshow.Model.PhotoModel;
import com.kb.photoshow.Persistent.AppDatabase;
import com.kb.photoshow.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity{

    // https://api.flickr.com/services/rest/
    // ?method=flickr.galleries.getPhotos
    // &api_key=b5adf013f6be330db59e33070c658f55
    // &gallery_id=72157643238009354
    // &format=json
    // &nojsoncallback=1
//https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key=29f8924e6f243438b8d3608d7ac66bad&gallery_id=72157680464381500&format=json&nojsoncallback=1
//    private final String URL_DATA = "https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key=2e716c7d81c7cd25a6ef89e462c872f4&gallery_id=72157643238009354&format=json&nojsoncallback=1";
    private final String METHOD = "flickr.galleries.getPhotos";
    private final String API_KEY = "2e716c7d81c7cd25a6ef89e462c872f4";
    private final String GALLERY_ID = "72157680464381500";
    private final String FORMAT = "json";
    private final int CALL_BACK = 1;

    private AppDatabase appDatabase;
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private int statusCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //room persistent
        appDatabase= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Photos")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        //check if URL is all right
        if (GALLERY_ID.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain valid GALLERY_ID", Toast.LENGTH_LONG).show();
            return;
        }

        //define recyclerview
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //start with local
           loadDataFromLocal();

        // try with network data
        if (com.kb.photoshow.Persistent.Utils.isNetworkAvailable(getApplicationContext())) {
           loadDataOnline();
        }
    }

    private void loadDataOnline() {

        //populate list from api json
        ApiInterface apiService= ApiClient.getClient().create(ApiInterface.class);

        Call<PhotoResponse> call=apiService.Photos(METHOD,API_KEY,GALLERY_ID,FORMAT,CALL_BACK);
          call.enqueue(new Callback<PhotoResponse>() {
              @Override
              public void onResponse(Call<PhotoResponse> call, retrofit2.Response<PhotoResponse> response) {
                  statusCode=response.code();
                  ArrayList<PhotoModel> photos = response.body().getMainPhotos().getPhoto();

                  // Update database
                  appDatabase.photoDao().insertAll(photos);

                  // Update visible list from Database.
                  loadDataFromLocal();

              }

              @Override
              public void onFailure(Call<PhotoResponse> call, Throwable t) {
                  Toast.makeText(MainActivity.this,"Error :"+statusCode+t.toString(),Toast.LENGTH_LONG).show();
                  // if no network, get local data instead
                  loadDataFromLocal();
              }
        });
            }

    //if no network, get data from local database
    private void loadDataFromLocal(){
        //Show loading...
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        List<PhotoModel> photos = appDatabase.photoDao().getAllPhotos();

        photoAdapter = new PhotoAdapter(photos);
        recyclerView.setAdapter(photoAdapter);
        progressDialog.dismiss();
    }
}
