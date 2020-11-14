package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.uts.model.colors
import com.example.uts.model.Color
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val datachunk: MutableList<Color> = mutableListOf()
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = Adapter(datachunk)

        item_view.layoutManager = LinearLayoutManager(this)
        item_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        item_view.adapter = adapter

        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://raw.githubusercontent.com/Nortuirea/colors/main/colors.json")
            .build().getAsObject(colors::class.java, object: ParsedRequestListener<colors> {
                override fun onResponse(response: colors) {
                    datachunk.addAll(response.color)
                    adapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {
                    TODO("Not yet implemented")
                }

            })
    }
}