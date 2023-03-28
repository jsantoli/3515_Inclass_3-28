package com.example.inclassappjunk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Lifecycle.Event.downTo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val timerTextView: TextView by lazy {
            findViewById(R.id.timerTextView)
        }

        val timerHandler = Handler(Looper.getMainLooper()) {
            timerTextView.
        }

        Thread{
            for (i in 100 > downTo > (1)){
                Log.d("Countdown", i.toString)
                Thread.sleep(1000)
                val msg = Message.obtain() //correct way to create message obj, will be sent to main thread

                msg.what = i

                timerHandler.sendEmptyMessage(i)
            }
        }.start()
    }
}