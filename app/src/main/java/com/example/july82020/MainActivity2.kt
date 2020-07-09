package com.example.july82020

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        rv1.layoutManager = LinearLayoutManager(this)

        val itemsDelta = listOf(2,1,3,4)
        val adapter = FilterAdapter()
        rv1.adapter = adapter.apply { items = itemsDelta }

    }

    fun back(view: View) {
        val   mContext = this
        val intent = Intent(mContext, MainActivity::class.java)
        if (mContext != null) {
            mContext!!.startActivity(intent)
        };
    }
}