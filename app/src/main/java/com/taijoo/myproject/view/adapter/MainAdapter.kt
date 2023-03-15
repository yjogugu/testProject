package com.taijoo.myproject.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taijoo.myproject.R
import com.taijoo.myproject.data.model.Memo
import com.taijoo.myproject.databinding.ItemLayoutMemoBinding

class MainAdapter(private val item : List<Memo>) : RecyclerView.Adapter<MainAdapter.MemoViewHolder>() {

//    private val item : List<Memo> = ArrayList<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {

        val itemMemoBinding : ItemLayoutMemoBinding = ItemLayoutMemoBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MemoViewHolder(itemMemoBinding)

    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {

        holder.bind(item = item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class MemoViewHolder(private val binding :ItemLayoutMemoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : Memo){
            binding.apply {
                this.memoItem = item
                Glide.with(binding.root).load(R.drawable.ic_launcher_background)
                    .circleCrop().into(binding.imageView)
                executePendingBindings()
            }

        }

    }
}