package com.example.myapplication.ui

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Slots
import com.example.myapplication.ui.adapter.TimeSlotsAdapter
import com.example.myapplication.ui.adapter.WeekDaysAdapter
import com.example.myapplication.utils.hide
import com.example.myapplication.utils.show
import com.example.myapplication.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormatSymbols

/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */

class MainActivity : BaseActivity<ActivityMainBinding>(), WeekDaysAdapter.OnDaysCLickListener,
    TimeSlotsAdapter.OnTimeSlotCLickListener {


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getLayout()  = binding


    private val viewModel: MainViewModel by viewModel()
    private val weekDays by lazy { DateFormatSymbols() }
    private val daysAdapter by lazy { WeekDaysAdapter(emptyArray()) }
    private val timeSlotsAdapter by lazy { TimeSlotsAdapter(arrayListOf()) }
    private var slots: ArrayList<Slots> ?= null
    private var timeSlot = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTimeSlots()
        apiResponse()
        setUpRecyclerView()
        setListeners()
        daysAdapter.updateAdapter(weekDays.shortWeekdays)
        binding.btnSelectTime.setOnClickListener {
            if (timeSlot.isNotEmpty()) {
                showToast(timeSlot)
            } else {
                showToast(getString(R.string.select_time_slot))
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.rvWeekDays.adapter = daysAdapter
        binding.rvTimeSlots.adapter = timeSlotsAdapter
    }

    private fun setListeners() {
        daysAdapter.setListener(this)
        timeSlotsAdapter.setListener(this)
    }

    private fun apiResponse() {
        viewModel.showLoading.observe(this) { showLoading ->
            if (showLoading) {
                showLoading()
            } else {
                hideLoading()
            }
        }

        viewModel.getTimeSlots.observe(this) {
            slots = it.data
        }
    }

    override fun onDayCLick(day: String) {
        val filteredSlot = slots?.filter { it.day == day }
        if (!filteredSlot.isNullOrEmpty()) {
            timeSlotsAdapter.updateAdapter(filteredSlot as ArrayList<Slots>)
            binding.rvTimeSlots.show()
            binding.tvNoTimeSlot.hide()
        } else {
            binding.rvTimeSlots.hide()
            binding.tvNoTimeSlot.show()
        }
    }

    override fun timeSlotCLick(slotTime: String?) {
        slots?.map { it.isChecked = false }
        timeSlot = slotTime.toString()
    }

}