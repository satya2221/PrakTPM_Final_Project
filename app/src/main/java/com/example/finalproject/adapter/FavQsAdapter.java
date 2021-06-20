package com.example.finalproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.model.QuotesItem;

import java.util.ArrayList;

public class FavQsAdapter extends RecyclerView.Adapter<FavQsAdapter.viewHolder> {

    private ArrayList<QuotesItem> quotesItems = new ArrayList<>();

    public void setData(ArrayList<QuotesItem> items){
        quotesItems.clear();
        quotesItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavQsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavQsAdapter.viewHolder holder, int position) {
        holder.tv_quote_body.setText(quotesItems.get(position).getBody());
        holder.tv_quote_author.setText(quotesItems.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return quotesItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv_quote_body, tv_quote_author;
        CardView cvItem;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            tv_quote_body = itemView.findViewById(R.id.itemlist_quote_body);
            tv_quote_author = itemView.findViewById(R.id.itemlist_quote_author);
        }
    }
}
