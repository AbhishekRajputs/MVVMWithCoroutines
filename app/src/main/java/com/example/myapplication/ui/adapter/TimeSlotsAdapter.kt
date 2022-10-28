package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemTimeSlotBinding
import com.example.myapplication.model.Slots

/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */
class TimeSlotsAdapter(var list: ArrayList<Slots>) :
    RecyclerView.Adapter<TimeSlotsAdapter.ViewHolder>() {

    private lateinit var listener: OnTimeSlotCLickListener

    fun setListener(onTimeSlotCLickListener: OnTimeSlotCLickListener){
        listener = onTimeSlotCLickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTimeSlotBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    fun updateAdapter(list: ArrayList<Slots>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private var view: ItemTimeSlotBinding) : RecyclerView.ViewHolder(view.root) {
        fun bindItems(data: Slots) {
            view.rbTimeSlot.isChecked = data.isChecked

            view.rbTimeSlot.text = data.slot_time

            view.rbTimeSlot.setOnClickListener {
                listener.timeSlotCLick(data.slot_time)

                data.isChecked = true
                notifyDataSetChanged()
            }
        }
    }

    interface OnTimeSlotCLickListener{
        fun timeSlotCLick(slotTime: String?)
    }
}