package com.example.b11109008_hw2

import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ThirdFragment:AppCompatActivity() , OnMapReadyCallback{
    var locationCoords :DoubleArray? = doubleArrayOf(0.0,0.0)
    override fun onCreate(savedInstanceState: Bundle?) {
        val gmap: GoogleMap
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_third)
        locationCoords = intent.getDoubleArrayExtra("locationCoords")
        val mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.id_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(gMap: GoogleMap) {
        val loc = LatLng(locationCoords!![0], locationCoords!![1])
        gMap.addMarker(MarkerOptions().position(loc).title(intent.getStringExtra("locationName")))
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 15f))
    }
}