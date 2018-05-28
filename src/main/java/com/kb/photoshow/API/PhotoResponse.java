package com.kb.photoshow.API;

import com.google.gson.annotations.SerializedName;
import com.kb.photoshow.Model.PhotoModel;

import java.util.ArrayList;

/**
 * Created by kanbi on 22/05/2018.
 */

public class PhotoResponse {

    //related json format
//     "photos":{
//                "page":1,
//                "pages":1,
//                "perpage":100,
//                "total":18,
//                "photo":[
//        {}]}
//     "stat":"ok"


    @SerializedName("photos")
    public MainPhotos mainPhotos;

    @SerializedName("stat")
      public String stat;


    public MainPhotos getMainPhotos() {
        return mainPhotos;
    }

    public void setMainPhotos(MainPhotos mainPhotos) {
        this.mainPhotos = mainPhotos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }


    public class MainPhotos
    {
        @SerializedName("page")
        private int page;

        @SerializedName("pages")
        private int pages;

        @SerializedName("perpage")
        private int perpage;

        @SerializedName("total")
        private int total;

        @SerializedName("photo")
        private ArrayList<PhotoModel> photo;


        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPerpage() {
            return perpage;
        }

        public void setPerpage(int perpage) {
            this.perpage = perpage;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public ArrayList<PhotoModel> getPhoto() {
            return photo;
        }

        public void setPhoto(ArrayList<PhotoModel> photo) {
            this.photo = photo;
        }
    }

}
