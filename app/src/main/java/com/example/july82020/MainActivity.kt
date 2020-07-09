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
            Profile("danila", R.drawable.ic_launcher_background, "hype"),
            Text(
                "Title", "android:layout_height=\"match_parent\tools:context=\".MainActivity\">   <androidx.recyclerview.widget.RecyclerView\nandroid:layout_width=\"match_parent\"\nandroid:layout_height=\"match_parent\"\nandroid:id=\"@+id/recycler\">\n</androidx.recyclerview.widget.RecyclerView>\n</androidx.constraintlayout.widget.ConstraintLayout>"
            ),
            Filter("Experience"), Skill("Java", 4), Skill("SQL", 2), Skill("C++", 3)
        )
        val adapter = Adapter(this)
        recycler.adapter = adapter.apply { items = itemsDelta }
    }
}
