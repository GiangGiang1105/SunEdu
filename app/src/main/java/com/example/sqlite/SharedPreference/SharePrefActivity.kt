package com.example.sqlite.SharedPreference

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlite.R
import kotlinx.android.synthetic.main.activity_share_pref.*

class SharePrefActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private var color = R.color.green
    private var sum = 0
    private var sharedPreferences = "com.example.android.hellosharedprefs"
    private var mPreferences: SharedPreferences? = null

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_pref)
        mPreferences = getSharedPreferences(sharedPreferences, MODE_PRIVATE)
        mPreferences?.let {
            color = it.getInt("Color", R.color.green)
            sum = it.getInt("Count", 0)
        }
        frame.setBackgroundColor(color)
        textSum.text = sum.toString()
        handleClick()
    }

    override fun onPause() {
        super.onPause()
        val editor = mPreferences?.edit()
        editor?.putInt("Count", sum)
        editor?.putInt("Color", color)
        editor?.apply()
    }

    override fun onResume() {
        super.onResume()
        mPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key.equals("Count")) Toast.makeText(this, "Count" + sum, Toast.LENGTH_LONG).show()
    }

    @SuppressLint("ResourceAsColor")
    private fun handleClick() {
        buttonCount.setOnClickListener {
            sum += 1
            textSum.text = sum.toString()
        }
        red.setOnClickListener {
            frame.setBackgroundColor(R.color.red)
            color = R.color.red
        }
        green.setOnClickListener {
            frame.setBackgroundColor(R.color.green)
            color = R.color.green
        }
        yellow.setOnClickListener {
            frame.setBackgroundColor(R.color.yellow)
            color = R.color.yellow
        }
        pink.setOnClickListener {
            frame.setBackgroundColor(R.color.pink)
            color = R.color.pink
        }
    }
}