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

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<Game>mGamelist;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View gameView;
        ImageView gameImage;
        TextView gameName;

        public ViewHolder(View view)
        {
            super(view);
            gameView=view;
            gameImage=(ImageView) view.findViewById(R.id.game_image);
            gameName=(TextView)view.findViewById(R.id.game_name);
        }
    }

    public GameAdapter(List<Game>gameList)
    {
        mGamelist=gameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.gameView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Game game=mGamelist.get(position);
                Toast.makeText(v.getContext(),"You clicker view"+game.getGameName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.gameImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Game game=mGamelist.get(position);
                Toast.makeText(v.getContext(),"You clicked image"+game.getGameName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Game game=mGamelist.get(i);
        viewHolder.gameName.setText(game.getGameName());
        viewHolder.gameImage.setImageResource(game.getGameImage());
    }

    @Override
    public int getItemCount() {
        return mGamelist.size();
    }
}
