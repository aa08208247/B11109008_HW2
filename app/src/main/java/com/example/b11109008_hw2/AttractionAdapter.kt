package com.example.b11109008_hw2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class AttractionAdapter(
    context: Context,
    private val attractions: Array<Attraction>
) : ArrayAdapter<Attraction>(context, 0, attractions) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)
        val attraction = getItem(position)

        val textView: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        textView.text = context.getString(attraction!!.nameResId)
        imageView.setImageDrawable(ContextCompat.getDrawable(context, attraction.imageResId))

        return view
    }
}
