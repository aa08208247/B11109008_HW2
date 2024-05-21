package com.example.b11109008_hw2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val attractionName = intent.getStringExtra("attractionName")
        val attractionDetails = intent.getStringExtra("attractionDetails")
        val attractionImage = intent.getIntExtra("attractionImage", 0)
        supportActionBar?.title =attractionName

        val nameTextView: TextView = findViewById(R.id.textView)
        val detailsTextView: TextView = findViewById(R.id.detailsView)
        val imageView: ImageView = findViewById(R.id.imageView)

        nameTextView.text = attractionName
        detailsTextView.text = attractionDetails
        imageView.setImageResource(attractionImage)

        val button : Button = findViewById(R.id.GoogleMapsButton)
        button.setOnClickListener{
            val intent = Intent(this, ThirdFragment::class.java)
            intent.putExtra("locationCoords", this.intent.getDoubleArrayExtra("locationCoords"))
            intent.putExtra("locationName", this.intent.getStringExtra("attractionName"))
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
