package com.example.uts

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class Adapter (private val dataChunk: MutableList<com.example.uts.model.Color>):
    RecyclerView.Adapter<RecyclerViewHolder>() {
    private lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        context = parent.context
        return RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val data = dataChunk[position]

        val recycler_color_name = holder.itemView.color_name
        val recycler_color_button = holder.itemView.color_button
        val recycler_color_rgb = holder.itemView.color_rgb

        recycler_color_name.text = data.color
        recycler_color_rgb.text = data.rgb.toString()
        val color_hex = String.format("#%02x%02x%02x%02x", data.rgb[3]*255, data.rgb[0], data.rgb[1], data.rgb[2])
//        print("color hex ARGB: ${color_hex}")

        recycler_color_button.setBackgroundColor(Color.parseColor(color_hex))
        recycler_color_button.setOnClickListener{
            val intent = Intent(this.context, MainActivity2::class.java)
            MainActivity2.sendColor(color_hex)
            startActivity(context, intent, Bundle())
        }
    }

    override fun getItemCount(): Int = dataChunk.size

}