package com.example.hellosample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンに対してリスナを設定
        val listener = HelloListener()

        findViewById<Button>(R.id.btClick).apply {
            setOnClickListener(listener)
        }

        findViewById<Button>(R.id.btClear).apply {
            setOnClickListener(listener)
        }
    }

    private inner class HelloListener: View.OnClickListener {

        override fun onClick(v: View) {

            // EditTextを取得
            val input = findViewById<EditText>(R.id.etName)

            // TextViewを取得
            val output = findViewById<TextView>(R.id.tvOutput)

            // IDによって処理を分岐させる
            when(v.id) {

                // 表示ボタン押下時の処理
                R.id.btClick -> {
                    val inputStr = input.text.toString()
                    output.text = inputStr + "さん、こんにちは!"
                }

                // クリアボタン押下時の処理
                R.id.btClear -> {
                    input.setText("")
                    output.text = ""
                }
            }


        }

    }
}
