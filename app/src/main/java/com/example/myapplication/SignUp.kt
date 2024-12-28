package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val changeButton: MaterialButton = findViewById(R.id.swap_button)
        var fragmentSwitch: Boolean = true;

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FragmentA())
            .commit()

        changeButton.setOnClickListener {
            if(fragmentSwitch) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentB())
                    .addToBackStack(null)
                    .commit()
            }
            else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentA())
                    .addToBackStack(null)
                    .commit()
            }
            fragmentSwitch = !fragmentSwitch
        }
    }
}



