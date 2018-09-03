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

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article>mArticlelist;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView articleImage;
        TextView articleContent;

        public ViewHolder(View view)
        {
            super(view);
            articleImage=(ImageView) view.findViewById(R.id.article_image);
            articleContent=(TextView) view.findViewById(R.id.article_content);
        }
    }

    public ArticleAdapter(List<Article>articleList)
    {
        mArticlelist=articleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Article article=mArticlelist.get(i);
        viewHolder.articleContent.setText(article.articleContent);
        viewHolder.articleImage.setImageResource(article.articleImage);
    }

    @Override
    public int getItemCount() {
        return mArticlelist.size();
    }
}

