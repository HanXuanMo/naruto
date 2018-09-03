package com.naruto.android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EvaluationAdapter extends RecyclerView.Adapter<EvaluationAdapter.ViewHolder> {

    private List<Evaluation> mEvaluationList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView evaluationImage;
        TextView evaluationTitle;

        public ViewHolder(View view) {
            super(view);
            evaluationImage = (ImageView) view.findViewById(R.id.evaluation_image);
            evaluationTitle = (TextView) view.findViewById(R.id.evaluation_Title);
        }
    }

    public EvaluationAdapter(List<Evaluation> evaluationList) {
        mEvaluationList = evaluationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_evaluation, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Evaluation evaluation = mEvaluationList.get(i);
        viewHolder.evaluationImage.setImageResource(evaluation.getEvaluationImage());
        viewHolder.evaluationTitle.setText(evaluation.getEvaluationTitle());
    }

    @Override
    public int getItemCount() {
        return mEvaluationList.size();
    }
}
