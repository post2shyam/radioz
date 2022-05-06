package com.androidz.radioz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidz.radioz.databinding.ActivityMainBinding
import com.androidz.radioz.system.MainApplication
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.e("${MainApplication::class}")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val radioStations = dummyRadioStationList()
        binding.recyclerLauncherView.layoutManager = LinearLayoutManager(this)

        binding.recyclerLauncherView.adapter =
            RadioListAdapter(RadioPlayer(this).apply { open() }, radioStations)
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