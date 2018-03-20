package com.example.bg.mybooks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by bg on 11/3/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
   ArrayList<Album> arrayList=new ArrayList<>();
   RecyclerAdapter(ArrayList<Album> arrayList)
   {
       this.arrayList=arrayList;
   }
    @Override
    public MyViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       holder.imageView.setImageResource(arrayList.get(position).getImg_id());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView =(ImageView)itemView.findViewById(R.id.album);
        }
    }
}
