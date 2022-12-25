package com.example.selfhealth_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.selfhealth_app.R

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
    }
    fun onRadioButtonClicked(view: ) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rdb1 ->
                    if (checked) {

                    }
                R.id.rdb2 ->
                    if (checked) {

                    }
                R.id.rdb3 ->
                    if (checked) {

                    }
            }
        }
    }
}