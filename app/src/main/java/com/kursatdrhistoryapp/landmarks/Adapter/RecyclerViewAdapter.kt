package com.kursatdrhistoryapp.landmarks.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kursatdrhistoryapp.landmarks.view.InfoActivity
import com.kursatdrhistoryapp.landmarks.model.Landmarks
import com.kursatdrhistoryapp.landmarks.databinding.RowBinding

class RecyclerViewAdapter (val landmarklist : ArrayList<Landmarks>) : RecyclerView.Adapter<RecyclerViewAdapter.LandmarkHolder>() {

    class LandmarkHolder (val binding : RowBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
      val binding = RowBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
      return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.rowNameText.text = landmarklist.get(position).name
        holder.binding.rowCitytext.text = landmarklist.get(position).city
        holder.binding.rowImageview.setImageResource(landmarklist.get(position).main_image)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context , InfoActivity::class.java)
            intent.putExtra("landmark", landmarklist.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return landmarklist.size
    }
}