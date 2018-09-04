package com.naruto.android;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        final View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_game,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        //游戏列表点击事件
        holder.gameView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Game game=mGamelist.get(position);
                Toast.makeText(v.getContext(),"You clicker view"+game.getGameName(),Toast.LENGTH_SHORT).show();
                Game_item_content.actionStart(v.getContext(),game.getGameName(),game.getGameImage());
            }
        });
        holder.gameImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Game game=mGamelist.get(position);
                Toast.makeText(v.getContext(),"You clicked image"+game.getGameName(),Toast.LENGTH_SHORT).show();
                Game_item_content.actionStart(v.getContext(),game.getGameName(),game.getGameImage());
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
