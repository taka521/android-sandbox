package com.example.lifecyclesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycleSample", "SubActivity onCreate() called.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }

    override fun onStart() {
        Log.i("LifeCycleSample", "SubActivity onStart() called.")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("LifeCycleSample", "SubActivity onRestart() called.")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("LifeCycleSample", "SubActivity onResume() called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifeCycleSample", "SubActivity onPause() called.")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifeCycleSample", "SubActivity onStop() called.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("LifeCycleSample", "SubActivity onDestroy() called.")
        super.onDestroy()
    }

    fun onButtonClick(view: View) {
        finish()
    }
}
