package com.kursatdrhistoryapp.landmarks.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.kursatdrhistoryapp.landmarks.Adapter.RecyclerViewAdapter
import com.kursatdrhistoryapp.landmarks.model.Landmarks
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
 private lateinit var binding : ActivityMainBinding
 private lateinit var list : ArrayList<Landmarks>
 private lateinit var displayList : ArrayList<Landmarks>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList<Landmarks>()
        displayList = ArrayList<Landmarks>()

        fillTheArray ()

        displayList.addAll(list)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter(displayList)
        binding.recyclerView.adapter = adapter


        //functions
        bottomNavigation()

        searchView ()


        // make invisible
        binding.searchView.visibility = View.INVISIBLE



    }

    fun fillTheArray ()
    {
        val maindentower = Landmarks("Maiden's Tower" ,
            "Istanbul",
            "One of the most iconic images of Istanbul surely has to be the Kız Kulesi Üsküdar, known in English as Maiden’s Tower, Tower of Leandros, Leander’s Tower or Bosphorus Tower. It is found on a small natural islet in the Bosphorus, just off the shore of Asian Istanbul.\n" +
                    "\n" +
                    "It’s possible to take a boat from either from Kabataş or Salacak (on the road between Uskudar and Harem). It takes 10 minutes from Kabataş and less than a minute from Üsküdar. Make sure to check the time schedule of the boat service in advance. \n",
            R.mipmap.main_maidenstower ,
            R.mipmap.info_maidentower
        )
        val eiffel = Landmarks("Eiffel" ,
            "Paris",
            "The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company designed and built the tower.\n" +
                    "\n" +
                    "More than 250 million people have visited the tower since it was completed in 1889. In 2015, there were 6.91 million visitors.] The tower is the most-visited paid monument in the world. An average of 25,000 people ascend the tower every day which can result in long queues. \n",
            R.mipmap.main_eiffel ,
            R.mipmap.info_eiffel
        )
        val brandenburg = Landmarks("Brandenburg Gate" ,
            "Berlin",
            "The Brandenburg is an 18th-century neoclassical monument in Berlin, built on the orders of Prussian king Frederick William II after the temporary restoration of order during the Batavian Revolution.\n" +
                    "\n" +
                    "One of the best-known landmarks of Germany, it was built on the site of a former city gate that marked the start of the road from Berlin to the town of Brandenburg an der Havel, which used to be the capital of the Margraviate of Brandenburg.\n",
            R.mipmap.main_brandenburg ,
            R.mipmap.info_brandenburg
        )
        val westminster = Landmarks("Westminster" ,
            "London",
            "Westminster is an area of Central London, part of the wider City of Westminster.\n" +
                    "\n" +
                    "The area, which extends from the River Thames[1] to Oxford Street has many visitor attractions and historic landmarks, including the Palace of Westminster, Buckingham Palace, Westminster Abbey, Westminster Cathedral and much of the West End shopping and entertainment district.\n",
            R.mipmap.main_west ,
            R.mipmap.info_west
        )


        list.add(maindentower)
        list.add(eiffel)
        list.add(brandenburg)
        list.add(westminster)
    }


    fun bottomNavigation()
    {
       val intentMain = Intent(this, MainActivity::class.java)


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> startActivity(intentMain)
                R.id.search ->  makevisibleSearchView()
                R.id.exit -> quitApp()
            }
            true
        }
    }


    fun searchView ()
    {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if(newText!!.isNotEmpty())
                {
                    displayList.clear()
                    val search = newText.toLowerCase(Locale.getDefault())
                    list.forEach {
                        if(it.city.toLowerCase(Locale.getDefault()).contains(search))
                        {
                            displayList.add(it)
                        }
                    }
                    binding.recyclerView.adapter!!.notifyDataSetChanged()
                }

                else
                {
                    displayList.clear()
                    displayList.addAll(list)
                    binding.recyclerView.adapter!!.notifyDataSetChanged()
                }
                return true
            }

        })
    }

    fun quitApp()
    {
        finishAffinity()
        System.exit(0);
    }

    fun makevisibleSearchView ()
    {
        val fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop)
        binding.searchView.visibility = View.VISIBLE
        binding.searchView.startAnimation(fromtop)
    }
}