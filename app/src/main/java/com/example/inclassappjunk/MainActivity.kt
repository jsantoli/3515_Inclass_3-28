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
import kotlinx.coroutines.*

lateinit var timerTextView: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTextView = findViewById(R.id.timerTextView)


        val scope = CoroutineScope(Job() + Dispatchers.Default)

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
                withContext(Dispatchers.Main){
                    timerTextView.text = this@run
                }

                Log.d("Countdown", this)
            }
            delay(1000)

        }
    }
}