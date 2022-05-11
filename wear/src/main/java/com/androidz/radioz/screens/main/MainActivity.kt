package com.androidz.radioz.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidz.radioz.application.MainApplication
import com.androidz.radioz.data.Player
import com.androidz.radioz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var player: Player

    @Inject
    lateinit var radioListAdapter: RadioListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val radioStations = dummyRadioStationList()
        binding.recyclerLauncherView.layoutManager = LinearLayoutManager(this)

        player.open()
        binding.recyclerLauncherView.adapter = radioListAdapter
    }

    private fun dummyRadioStationList(): List<RadioStationModel> {
        return listOf(
            RadioStationModel("First Station"),
            RadioStationModel("Second Station"),
            RadioStationModel("Third Station"),
            RadioStationModel("4 Station"),
            RadioStationModel("5 Station"),
            RadioStationModel("6 Station"),
            RadioStationModel("7 Station"),
            RadioStationModel("8 Station"),
            RadioStationModel("9 Station")
        )
    }
}