package com.kursatdrhistoryapp.landmarks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.model.Landmarks
import com.kursatdrhistoryapp.landmarks.repo.LandmarkRepo

class FeedViewModel : ViewModel() {
    var landmarkList = MutableLiveData<List<Landmarks>>()
    val landmarkRepo = LandmarkRepo()


    fun loadData() {
        landmarkRepo.landmarks()
        landmarkList = landmarkRepo.getList()
    }
}