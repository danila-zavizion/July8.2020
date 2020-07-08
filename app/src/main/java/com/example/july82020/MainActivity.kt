package com.example.july82020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)

        val itemsDelta = listOf(
            Profile("danila", R.mipmap.ic_launcher, "hype"),
            Text(
                "Title", "android:layout_height=\"match_parent\tools:context=\".MainActivity\">   <androidx.recyclerview.widget.RecyclerView\nandroid:layout_width=\"match_parent\"\nandroid:layout_height=\"match_parent\"\nandroid:id=\"@+id/recycler\">\n</androidx.recyclerview.widget.RecyclerView>\n</androidx.constraintlayout.widget.ConstraintLayout>"
            ),
            Skill("Java", 4), Filter("Experience"), Profile("danila2", R.mipmap.ic_launcher, "hype")
        )
        recycler.adapter =
            Adapter {}.apply { items = itemsDelta }
    }
}
