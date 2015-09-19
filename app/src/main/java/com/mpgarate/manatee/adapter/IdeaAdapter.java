package com.mpgarate.manatee.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mpgarate.manatee.R;

import java.util.List;

public class IdeaAdapter extends RecyclerView.Adapter<IdeaAdapter
        .IdeaViewHolder> {
    private List<String> ideas;

    public static class IdeaViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView ideaText;

        public IdeaViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.idea_cardview);
            ideaText = (TextView) v.findViewById(R.id.idea_text);
        }
    }

    public IdeaAdapter(List<String> ideas) {
        this.ideas = ideas;
    }

    @Override
    public IdeaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .idea_card, parent, false);

        IdeaViewHolder vh = new IdeaViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(IdeaViewHolder viewHolder, int position) {
        Log.i("vh", viewHolder.toString());
        Log.i("pos", "" + position);
        Log.i("idea", ideas.get(position));

        viewHolder.ideaText.setText(ideas.get(position));
    }

    @Override
    public int getItemCount() {
        return ideas.size();
    }

}
