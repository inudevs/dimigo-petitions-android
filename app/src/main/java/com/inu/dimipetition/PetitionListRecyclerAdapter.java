package com.inu.dimipetition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetitionListRecyclerAdapter extends RecyclerView.Adapter<PetitionListRecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PetitionItem> items = new ArrayList<PetitionItem>();

    public PetitionListRecyclerAdapter(Context context, ArrayList<PetitionItem> items) {
        this.context = context;
        this.items = items;
    }

    public PetitionListRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_petition, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final PetitionItem item = items.get(position);
        holder.category.setText(item.getCategory());
        holder.title.setText(item.getTitle());
        holder.participant.setText(item.getParticipant().toString());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PetitionActivity.class);
                intent.putExtra("data",items.get(position));
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context,
                                holder.root,
                                Objects.requireNonNull(ViewCompat.getTransitionName(holder.root)));
                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void addItem(String category, String title, Integer participant)
    {
        PetitionItem item = new PetitionItem(category, title, participant);
        items.add(item);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView category;
        TextView title;
        TextView participant;

        LinearLayout root;

        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.text_category);
            title = (TextView) itemView.findViewById(R.id.text_title);
            participant = (TextView) itemView.findViewById(R.id.text_participant);

            root = (LinearLayout) itemView.findViewById(R.id.layout_root);

            cardview = (CardView) itemView.findViewById(R.id.cardview_root);
        }
    }
}
