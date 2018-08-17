package com.olehliskovych.placenote.ui.note.picking

import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.AsyncListDiffer
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.olehliskovych.placenote.R
import com.olehliskovych.placenote.data.entities.Label
import com.olehliskovych.placenote.databinding.ItemLabelsPickingBinding
import javax.inject.Inject

class LabelsPickingAdapter @Inject
constructor() : RecyclerView.Adapter<LabelsPickingAdapter.PickingViewHolder>() {

    private val list: List<Label>? = null

    private val asyncDiffer: AsyncListDiffer<Label>

    init {
        this.asyncDiffer = AsyncListDiffer(this, DIFF_CALLBACK)
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Label>() {
            override fun areItemsTheSame(oldItem: Label, newItem: Label): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Label, newItem: Label): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickingViewHolder {
        val binding = DataBindingUtil.inflate<ItemLabelsPickingBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_labels_picking, parent, false
        )

        return PickingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PickingViewHolder, position: Int) {
        val label = list!![position]
        holder.bind(label)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class PickingViewHolder(internal var binding: ItemLabelsPickingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(label: Label) {
            binding.label = label
            binding.executePendingBindings()
        }
    }
}
