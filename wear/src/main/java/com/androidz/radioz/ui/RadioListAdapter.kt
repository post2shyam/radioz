package com.androidz.radioz.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidz.radioz.databinding.RadioListItemBinding

class RadioListAdapter(private val radioStations: List<RadioStationModel>) :
    RecyclerView.Adapter<RadioListAdapter.RadioItemViewHolder>() {
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


    inner class RadioItemViewHolder(private val itemBinding: RadioListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val TAG: String = RadioItemViewHolder::class.java.name

        init {
            itemBinding.radioItem.setOnClickListener(View.OnClickListener {
                Log.e(TAG, ": ")
            })
        }

        fun updateUi(radioStationModel: RadioStationModel) {
            itemBinding.radioItem.text = radioStationModel.name
        }
    }
}