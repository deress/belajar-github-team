package com.dicoding.rosterseagames

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.dicoding.rosterseagames.databinding.ActivityDetailBinding
import androidx.appcompat.app.ActionBar

class DetailActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar = supportActionBar!!
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val dataRoster = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("detail_roster", Roster::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("detail_roster")
        }

        if (dataRoster != null) {
            binding.detailRosterName.text = dataRoster.name
            binding.detailRosterPosition.text = dataRoster.position
            binding.detailRosterWeight.text = dataRoster.weight
            binding.detailRosterHeight.text = dataRoster.height
            binding.detailRosterName.text = dataRoster.name
            binding.detailRosterBirthdate.text = dataRoster.birthdate
            binding.detailRosterDescription.text = dataRoster.description
            Glide.with(this)
                .load(dataRoster.cover_photo) // URL Gambar
                .into(binding.detailRosterPhoto) // imageView mana yang akan diterapkan
            Glide.with(this)
                .load(dataRoster.photo) // URL Gambar
                .into(binding.profileRosterPhoto) // imageView mana yang akan diterapkan
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val moveIntent = Intent(Intent.ACTION_SEND)
                moveIntent.type = "text/plain"
                moveIntent.putExtra(Intent.EXTRA_SUBJECT, "Download this cool Application")
                moveIntent.putExtra(Intent.EXTRA_TEXT, "http://play.google.com")
                startActivity(Intent.createChooser(moveIntent, "Share Via"))
            }
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}