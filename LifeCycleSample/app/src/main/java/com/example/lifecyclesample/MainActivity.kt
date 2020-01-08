package com.example.lifecyclesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycleSample", "Main onCreate() called.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.i("LifeCycleSample", "Main onStart() called.")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("LifeCycleSample", "Main onRestart() called.")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("LifeCycleSample", "Main onResume() called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifeCycleSample", "Main onPause() called.")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifeCycleSample", "Main onStop() called.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("LifeCycleSample", "Main onDestroy() called.")
        super.onDestroy()
    }

    fun onButtonClick(view: View) {
        val intent = Intent(applicationContext, SubActivity::class.java)
        startActivity(intent)
    }
}
