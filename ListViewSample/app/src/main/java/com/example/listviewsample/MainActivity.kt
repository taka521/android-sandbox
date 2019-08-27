package com.example.listviewsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リスナを設定
        findViewById<ListView>(R.id.lvMenu).apply {
            onItemClickListener = ListItemClickListener()
        }

    }


    private inner class ListItemClickListener: AdapterView.OnItemClickListener {

        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            // タップされた定食名を取得
            val item = parent.getItemAtPosition(position) as String

            // トーストに表示する文字列
            val show = "あなたが選んだ定食：$item"

            // トーストを表示
            Toast.makeText(applicationContext, show, Toast.LENGTH_LONG).show()
        }

    }
}
