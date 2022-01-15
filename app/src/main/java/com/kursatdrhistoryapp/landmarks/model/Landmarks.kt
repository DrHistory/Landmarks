package com.kursatdrhistoryapp.landmarks.model

import java.io.Serializable

class Landmarks (val name : String,
                 val city : String,
                 val info : String,
                 val main_image : Int,
                 val info_image : Int
                 ) : Serializable