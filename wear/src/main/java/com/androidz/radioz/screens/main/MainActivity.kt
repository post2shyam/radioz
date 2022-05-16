package com.androidz.radioz.screens.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidz.radioz.data.Player
import com.androidz.radioz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var player: Player

    @Inject
    lateinit var radioListAdapter: RadioListAdapter

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
        setupObservers()
    }

    private fun setupUi() {
        with(binding.recyclerLauncherView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = radioListAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupObservers() {
        mainActivityViewModel.getFavoriteStations().observe(this) {
            radioListAdapter.radioStations = transformToRadioStationModels(it)
            radioListAdapter.notifyDataSetChanged()
        }
    }

    private fun transformToRadioStationModels(radioStations: List<String>): List<RadioStationModel> {
        return radioStations.map { RadioStationModel(it) }
    }
}