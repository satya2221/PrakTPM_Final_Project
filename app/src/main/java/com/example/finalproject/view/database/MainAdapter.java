package com.example.finalproject.view.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.entity.DataQuote;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
    Context context;
    List<DataQuote> list;
    MainContact.view mView;

    public MainAdapter(Context context, List<DataQuote> list, MainContact.view mView) {
        this.context = context;
        this.list = list;
        this.mView = mView;
    }

    @NonNull
    @Override
    public MainAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        final DataQuote item = list.get(position);
        holder.tv_quote_body.setText(item.getQuote_body());
        holder.tv_quote_author.setText(item.getQuote_author());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.editData(item);
            }
        });

        holder.cvItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mView.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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
