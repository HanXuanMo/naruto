package com.naruto.android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> mVideolist;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView videoImage;
        TextView videoTitle;

        public ViewHolder(View view)
        {
            super(view);
            videoImage=(ImageView) view.findViewById(R.id.video_image);
            videoTitle=(TextView) view.findViewById(R.id.video_Title);
        }
    }

    public VideoAdapter(List<Video>videoList)
    {
        mVideolist=videoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Video video=mVideolist.get(i);
        viewHolder.videoTitle.setText(video.videoTitle);
        viewHolder.videoImage.setImageResource(video.videoImage);
    }

    @Override
    public int getItemCount() {
        return mVideolist.size();
    }
}
