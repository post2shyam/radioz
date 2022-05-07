package com.androidz.radioz.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidz.radioz.data.Player
import com.androidz.radioz.databinding.RadioListItemBinding
import timber.log.Timber

class RadioListAdapter(
    private val player: Player,
    private val radioStations: List<RadioStationModel>
) : RecyclerView.Adapter<RadioListAdapter.RadioItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = RadioListItemBinding.inflate(layoutInflater, parent, false)
        return RadioItemViewHolder(viewBinding)
    }

    override fun onBindViewHolder(radioItemViewHolder: RadioItemViewHolder, position: Int) {
        radioItemViewHolder.updateUi(radioStations[position])
    }

    override fun getItemCount(): Int {
        return radioStations.size
    }


    inner class RadioItemViewHolder(private val radioItemViewBinding: RadioListItemBinding) :
        RecyclerView.ViewHolder(radioItemViewBinding.root) {

        init {
            with(radioItemViewBinding) {
                radioItem.setOnClickListener {
                    Timber.d("Clicked: ${radioItem.text}")
                    //TODO: Send a hardcoded URI as of now, stop() seems not to work
                    player.stop()
                    player.setUrl("https://0n-90s.radionetz.de/0n-90s.mp3")
                    player.play()
                }
            }
        }

        fun updateUi(radioStationModel: RadioStationModel) {
            with(radioItemViewBinding) { radioItem.text = radioStationModel.name }
        }
    }
}