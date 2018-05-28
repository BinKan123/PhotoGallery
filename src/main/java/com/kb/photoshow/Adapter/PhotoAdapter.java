package com.kb.photoshow.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kb.photoshow.Model.PhotoModel;
import com.kb.photoshow.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kanbi on 20/05/2018.
 */

public class PhotoAdapter  extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>  {

    private List<PhotoModel> PhotoData;

    public PhotoAdapter(List<PhotoModel> photoData) {
        this.PhotoData = photoData;
    }

    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.ViewHolder holder, int i) {
        final PhotoModel item = PhotoData.get(i);

        holder.photoTitle.setText(item.getTitle());

        final Context context = holder.itemView.getContext();
        Picasso.with(context).load("https://c2"+".staticflickr.com/"+item.getFarm()+"/"
                + item.getServer()+"/"+item.getId()+"_"+item.getSecret()+"_b.jpg")
                .into(holder.photoImg);

    }

    @Override
    public int getItemCount() {
        return PhotoData.size();
       // return ( PhotoData == null ? 0 : PhotoData.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView photoTitle;
        public ImageView photoImg;

        public ViewHolder(View itemView) {
            super(itemView);

            photoTitle=(TextView) itemView.findViewById(R.id.photoTitle);
            photoImg=(ImageView) itemView.findViewById(R.id.photoImg);

        }
    }
}
