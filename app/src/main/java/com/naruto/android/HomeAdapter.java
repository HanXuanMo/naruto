package com.naruto.android;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Home>mhomeList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        VideoView videoView;
        TextView article1;
        TextView article2;
        TextView article3;

        public ViewHolder(@NonNull View view) {
            super(view);
            cardView=(CardView)view;
            videoView=(VideoView)view.findViewById(R.id.home_video);
            article1=(TextView)view.findViewById(R.id.home_article1);
            article2=(TextView)view.findViewById(R.id.home_article2);
            article3=(TextView)view.findViewById(R.id.home_article3);
        }
    }
    public HomeAdapter(List<Home>homeList)
    {
        mhomeList=homeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Home home=mhomeList.get(i);
        Uri uri=Uri.parse(home.getVideo());
        viewHolder.videoView.setVideoURI(uri);
        viewHolder.videoView.start();
        viewHolder.article1.setText(home.getArticle1());
        viewHolder.article2.setText(home.getArticle2());
        viewHolder.article3.setText(home.getArticle3());
    }

    @Override
    public int getItemCount() {
        return mhomeList.size();
    }
}
