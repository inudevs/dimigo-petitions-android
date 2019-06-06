package com.inu.dimipetition;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_petition, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PetitionItem item = items.get(position);
        holder.category.setText(item.getCategory());
        holder.title.setText(item.getTitle());
        holder.participant.setText(item.getParticipant().toString());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
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

        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.text_category);
            title = (TextView) itemView.findViewById(R.id.text_title);
            participant = (TextView) itemView.findViewById(R.id.text_participant);

            cardview = (CardView) itemView.findViewById(R.id.cardview_root);
        }
    }
}
