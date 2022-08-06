package com.kursatdrhistoryapp.landmarks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.model.Landmarks

class FeedViewModel : ViewModel() {
    var landmarkList = MutableLiveData<List<Landmarks>>()


    fun loadData() {
        val maidensTower = Landmarks(
            "Maiden's Tower",
            "İstanbul",
            "The Maiden's Tower also known as Leander's Tower (Tower of Leandros) since the medieval Byzantine period, is a tower on a small islet at the southern entrance of the Bosphorus strait, 200 m (220 yd) from the coast of Üsküdar in Istanbul, Turkey.",
            R.mipmap.main_maidenstower
        )
        val eiffelTower = Landmarks(
            "Eiffel Tower",
            "Paris",
            "Locally nicknamed \"La dame de fer\" (French for \"Iron Lady\"), it was constructed from 1887 to 1889 as the centerpiece of the 1889 World's Fair and was initially criticised by some of France's leading artists and intellectuals for its design, but it has become a global cultural icon of France and one of the most recognisable structures in the world",
            R.mipmap.main_eiffel
        )
        val brandenburgGate = Landmarks(
            "Brandenburg Gate",
            "Berlin",
            "It is located in the western part of the city centre of Berlin within Mitte, at the junction of Unter den Linden and Ebertstraße, immediately west of the Pariser Platz. One block to the north stands the Reichstag building, which houses the German parliament (Bundestag). The gate is the monumental entry to Unter den Linden, a boulevard of linden trees which led directly to the royal City Palace of the Prussian monarchs.",
            R.mipmap.main_brandenburg
        )

        val westminster = Landmarks(
            "Westminster",
            "London",
            "The name (Old English: Westmynstre) originated from the informal description of the abbey church and royal peculiar of St Peter's (Westminster Abbey), west of the City of London (until the English Reformation there was also an Eastminster, near the Tower of London, in the East End of London). The abbey's origins date from between the 7th and 10th centuries, but it rose to national prominence when rebuilt by Edward the Confessor in the 11th. It has been the home of England's government since about 1200, and from 1707 the Government of the United Kingdom. In 1539, it became a city.",
            R.mipmap.main_west
        )

        val landmarks = arrayListOf(
            maidensTower,
            eiffelTower,
            brandenburgGate,
            westminster
        )
        landmarkList.value = landmarks
    }
}