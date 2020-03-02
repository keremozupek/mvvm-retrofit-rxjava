package com.example.vngrschallange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vngrschallange.retrofit.RepositoryModel
import com.example.vngrschallange.retrofit.SearchResponse
import kotlinx.android.synthetic.main.item_view.view.*

class RcyViewAdapater(var info : ArrayList<RepositoryModel>) : RecyclerView.Adapter<RcyViewAdapater.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tv1 = itemView.tv1
    var tv2 = itemView.tv2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return info.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.tv1.text = info.get(position).name
    }
}