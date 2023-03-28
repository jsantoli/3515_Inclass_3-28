package com.example.inclassappjunk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Lifecycle.Event.downTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
lateinit var timerTextView: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTextView = findViewById(R.id.timerTextView)


        val scope = CoroutineScope(Job() + Dispatchers.Main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener() {
            scope.launch {
                countdownTimer()
            }
        }

    }

    suspend fun countdownTimer(){
        repeat(100) {
            (100 - it).toString().run {
                timerTextView.text = this
                Log.d("Countdown", this)
            }
            Thread.sleep(1000)

        }
    }
}