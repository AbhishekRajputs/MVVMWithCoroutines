package com.example.myapplication.model

data class Data(
    var slots: ArrayList<Slots>? = null
)

data class Slots(
    var day: String? = null,
    var slot_time: String? = null,
    var isChecked: Boolean = false
)



