package com.example.b11109008_hw2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 假設景點名稱和詳細信息存儲在字串資源中
        val attractions = arrayOf(
            Attraction(R.string.attraction_name_1, R.string.attraction_details_1, R.drawable.attraction1,  doubleArrayOf(25.033997767903607, 121.56453755288162)),
            Attraction(R.string.attraction_name_2, R.string.attraction_details_2, R.drawable.attraction2,  doubleArrayOf(25.110044288814706, 121.84516121210021)),
            Attraction(R.string.attraction_name_3, R.string.attraction_details_3, R.drawable.attraction3,  doubleArrayOf(25.10257883435003, 121.54853541073021)),
            Attraction(R.string.attraction_name_4, R.string.attraction_details_4, R.drawable.attraction4,  doubleArrayOf(23.8660365878956, 120.91412431789541)),
            Attraction(R.string.attraction_name_5, R.string.attraction_details_5, R.drawable.attraction5,  doubleArrayOf(24.078174550983018, 121.16504019899024)),
            Attraction(R.string.attraction_name_6, R.string.attraction_details_6, R.drawable.attraction6,  doubleArrayOf(23.577385559602313, 120.78536419816535)),
            Attraction(R.string.attraction_name_7, R.string.attraction_details_7, R.drawable.attraction7,  doubleArrayOf(25.02657005622686, 121.7381364530248)),
            Attraction(R.string.attraction_name_8, R.string.attraction_details_8, R.drawable.attraction8,  doubleArrayOf(23.099207814590137, 120.1655878574359)),
            Attraction(R.string.attraction_name_9, R.string.attraction_details_9, R.drawable.attraction9,  doubleArrayOf(25.20667862961727, 121.69044431212332)),
            Attraction(R.string.attraction_name_10, R.string.attraction_details_10, R.drawable.attraction10,  doubleArrayOf(24.194130093732568, 121.49073116837282))
        )

        // 創建 ArrayAdapter 並設置 ListView
        val adapter = AttractionAdapter(this, attractions)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = adapter
        // 點擊列表項目時打開 DetailActivity 並傳遞相應的景點信息
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("attractionName", getString(attractions[position].nameResId))
            intent.putExtra("attractionDetails", getString(attractions[position].detailsResId))
            intent.putExtra("attractionImage", attractions[position].imageResId)
            intent.putExtra("locationCoords", attractions[position].locationCoords)
            startActivity(intent)
        }
    }
}
