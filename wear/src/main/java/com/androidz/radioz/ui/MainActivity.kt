package com.androidz.radioz.ui

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidz.radioz.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val radioStations = dummyRadioStationList()
        binding.recyclerLauncherView.layoutManager = LinearLayoutManager(this)
        binding.recyclerLauncherView.adapter = RadioListAdapter(radioStations)
    }

    private fun dummyRadioStationList(): List<RadioStationModel> {
        return listOf(
            RadioStationModel("First Station"),
            RadioStationModel("Second Station"),
            RadioStationModel("Third Station")
        )
    }
}