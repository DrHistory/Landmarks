package com.kursatdrhistoryapp.landmarks.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kursatdrhistoryapp.landmarks.model.Landmarks
import com.kursatdrhistoryapp.landmarks.databinding.RowBinding
import com.kursatdrhistoryapp.landmarks.view.fragment.FeedFragmentDirections

class RecyclerViewAdapter(val landmarklist: List<Landmarks>) :
    RecyclerView.Adapter<RecyclerViewAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.rowNameText.text = landmarklist[position].name
        holder.binding.rowCitytext.text = landmarklist[position].city
        holder.binding.rowImageview.setImageResource(landmarklist[position].image)

        holder.itemView.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToDetailFragment(position)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return landmarklist.size
    }

}