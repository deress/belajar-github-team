package com.dicoding.rosterseagames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.rosterseagames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvRosters: RecyclerView
//    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Roster>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_main)

        rvRosters = findViewById(R.id.rv_rosters)
        rvRosters.setHasFixedSize(true)
        list.addAll(getListRosters())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutProfile::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListRosters(): ArrayList<Roster> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataCoverPhoto = resources.getStringArray(R.array.data_cover_photo)
        val dataWeight = resources.getStringArray(R.array.data_weight)
        val dataHeight = resources.getStringArray(R.array.data_height)
        val dataPosition = resources.getStringArray(R.array.data_position)
        val dataBirthdate = resources.getStringArray(R.array.data_birthdate)


        val listHero = ArrayList<Roster>()
        for (i in dataName.indices) {
            val roster = Roster(dataName[i], dataDescription[i], dataPhoto[i], dataCoverPhoto[i], dataWeight[i], dataHeight[i], dataPosition[i], dataBirthdate[i])
            listHero.add(roster)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvRosters.layoutManager = LinearLayoutManager(this)
        val listRosterAdapter = ListRosterAdapter(list)
        rvRosters.adapter = listRosterAdapter
    }
}