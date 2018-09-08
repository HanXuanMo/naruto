package com.naruto.android;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.ViewHolder> {

    private List<Intro>mIntrolist;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View introView;
        TextView introName;

        public ViewHolder(View view)
        {
            super(view);
            introView=view;
            introName=(TextView)view.findViewById(R.id.intro_name);
        }
    }

    public IntroAdapter(List<Intro>introList)
    {
        mIntrolist=introList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item_content_intro,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        //游戏列表点击事件
        holder.introView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Intro intro=mIntrolist.get(position);
                Toast.makeText(v.getContext(),"You clicker view"+intro.getIntroContent(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Intro intro=mIntrolist.get(i);
        viewHolder.introName.setText(intro.getIntroContent());
    }

    @Override
    public int getItemCount() {
        return mIntrolist.size();
    }
}
