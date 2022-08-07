package com.kursatdrhistoryapp.landmarks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kursatdrhistoryapp.landmarks.model.Landmarks
import com.kursatdrhistoryapp.landmarks.repo.LandmarkRepo

class DetailViewModel : ViewModel() {
    var selectedLandmark = MutableLiveData<List<Landmarks>>()
    val landmarkRepo = LandmarkRepo()


    fun loadData() {
        landmarkRepo.landmarks()
        selectedLandmark = landmarkRepo.getList()
    }
}