package com.olehliskovych.placenote.ui.note.picking;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.olehliskovych.placenote.R;
import com.olehliskovych.placenote.data.entities.Label;
import com.olehliskovych.placenote.databinding.ItemLabelsPickingBinding;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class LabelsPickingAdapter extends RecyclerView.Adapter<LabelsPickingAdapter.PickingViewHolder>{

    private List<Label> list;

    private final AsyncListDiffer<Label> asyncDiffer;

    @Inject
    public LabelsPickingAdapter() {
        this.asyncDiffer = new AsyncListDiffer<Label>(this, DIFF_CALLBACK);
    }

    @NonNull
    private static final DiffUtil.ItemCallback<Label> DIFF_CALLBACK = new DiffUtil.ItemCallback<Label>() {
        @Override
        public boolean areItemsTheSame(Label oldItem, Label newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(Label oldItem, Label newItem) {
            return Objects.equals(oldItem, newItem);
        }
    };

    @NonNull
    @Override
    public PickingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLabelsPickingBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_labels_picking, parent, false
        );

        return new PickingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PickingViewHolder holder, int position) {
        Label label = list.get(position);
        holder.bind(label);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PickingViewHolder extends RecyclerView.ViewHolder {

        ItemLabelsPickingBinding binding;

        public PickingViewHolder(ItemLabelsPickingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Label label) {
            binding.setLabel(label);
            binding.executePendingBindings();
        }
    }
}
