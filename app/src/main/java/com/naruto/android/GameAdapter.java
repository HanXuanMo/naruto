package com.naruto.android;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<Game>mGamelist;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gameImage;
        TextView gameName;

        public ViewHolder(View view)
        {
            super(view);
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Game game=mGamelist.get(i);
        viewHolder.gameName.setText(game.gameName);
        viewHolder.gameImage.setImageResource(game.gameImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
