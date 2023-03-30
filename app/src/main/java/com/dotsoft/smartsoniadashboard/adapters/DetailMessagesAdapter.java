package com.dotsoft.smartsoniadashboard.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dotsoft.smartsoniadashboard.R;
import com.dotsoft.smartsoniadashboard.objects.MessageObject;
import com.dotsoft.smartsoniadashboard.objects.SosAlert;

import java.util.ArrayList;

public class DetailMessagesAdapter extends RecyclerView.Adapter<DetailMessagesAdapter.ViewHolder> {

    private ArrayList<MessageObject> data;

    public DetailMessagesAdapter(ArrayList<MessageObject> data){
        this.data = data;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setAdapterList(ArrayList<MessageObject> newList) {
        this.data = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    public void addData(MessageObject item){
        int insertIndex = this.data.size();
        data.add(insertIndex, item);
        notifyItemRangeInserted(insertIndex, 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_detail_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.time.setText(this.data.get(position).getTime());
        holder.val1.setText(this.data.get(position).getTitle());
        holder.val2.setText(this.data.get(position).getNotes());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.adapter_detail_item;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView time, val1, val2;
        public ViewHolder(View view) {
            super(view);
            time = (TextView) view.findViewById(R.id.time);
            val1 = (TextView) view.findViewById(R.id.val_1);
            val2 = (TextView) view.findViewById(R.id.val_2);
        }
    }



}
