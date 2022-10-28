package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemWeekDayBinding

/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */
class WeekDaysAdapter(var list: Array<String>) :
    RecyclerView.Adapter<WeekDaysAdapter.ViewHolder>() {

    private lateinit var listener: OnDaysCLickListener

    fun setListener(onDaysCLickListener: OnDaysCLickListener) {
        listener = onDaysCLickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWeekDayBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    fun updateAdapter(list: Array<String>) {
        this.list = list.filter { it.isNotEmpty() }.toTypedArray()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private var view: ItemWeekDayBinding) : RecyclerView.ViewHolder(view.root) {
        fun bindItems(day: String) {
            view.tvDay.text = day
            itemView.setOnClickListener { listener.onDayCLick(day) }
        }
    }

    interface OnDaysCLickListener {
        fun onDayCLick(day: String)
    }
}