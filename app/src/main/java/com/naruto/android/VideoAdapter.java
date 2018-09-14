package com.naruto.android;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> mVideolist;

    static class ViewHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        TextView videoTitle;

        public ViewHolder(View view)
        {
            super(view);
            videoView=(VideoView)view.findViewById(R.id.video_play);
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

        Uri uri=Uri.parse(video.getUri());
        viewHolder.videoView.setVideoURI(uri);
        viewHolder.videoView.start();

        viewHolder.videoTitle.setText(video.videoTitle);
    }

    @Override
    public int getItemCount() {
        return mVideolist.size();
    }
}
