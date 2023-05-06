package com.example.mobdevpract5.UI.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobdevpract5.data.models.Hotels;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewItemViewHolder>{
    List<Hotels> data;

    public RecyclerViewAdapter() {
        this.data = new ArrayList<>();
    }


    public RecyclerViewAdapter(OnStateClickListener onClickListener, List<Hotels> data) {
        this.data = data;
    }

    public void updateData(List<Hotels> newData) {
        data = newData;

        notifyDataSetChanged();
    }

    public interface OnStateClickListener {
        void onStateClick(Hotels hotels, int position);
    }

    @NonNull
    @Override
    public RecyclerViewItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding mBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.getContext()));

        return new RecyclerViewItemViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewItemViewHolder holder, int position) {
        holder.binding.itemTextId.setText(data.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RecyclerViewItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewBinding binding;

        public RecyclerViewItemViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemViewBinding.bind(itemView);
        }
    }
}
