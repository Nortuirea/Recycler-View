package com.example.uts

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var hex_color: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        hex_color = getColor()
//        println("The color has been received succesfully ${hex_color}")
        bg_button.setBackgroundColor(Color.parseColor(hex_color))
        bg_button.setHint(null)
        bg_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            MainActivity2.sendColor(hex_color)
            ContextCompat.startActivity(this, intent, Bundle())
        }
    }

    companion object{
        private lateinit var _color: String
        fun sendColor(hex: String){
            _color = hex
//            print("Color parameter received\n ${_color}")
        }

        fun getColor(): String {
            return this._color
        }
    }

}