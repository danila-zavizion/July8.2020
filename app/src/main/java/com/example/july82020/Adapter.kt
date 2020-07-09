package com.example.july82020

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.checkbox_layout.view.*
import kotlinx.android.synthetic.main.filter_layout.view.*
import kotlinx.android.synthetic.main.item_lauout.view.*
import kotlinx.android.synthetic.main.profile_layout.view.*
import kotlinx.android.synthetic.main.skill_layout.view.*

class Adapter(
    private val onClick: Context
) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    private val LAYOUT_ONE = 0
    private val LAYOUT_TWO = 1
    private val LAYOUT_THREE = 2
    private val LAYOUT_FOUR = 3


     private val   mContext = onClick



    override fun getItemViewType(position: Int): Int {
        var x = 0
        if (items[position] is Profile) { x = 0 } else if (items[position] is Text) { x = 1 } else if (items[position] is Skill) { x = 2 } else if (items[position] is Filter) { x = 3 }
        return x
    }

    var items: List<One> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var k = R.layout.skill_layout
        if (viewType == 0) {  k = R.layout.profile_layout } else if (viewType == 1) { k = R.layout.item_lauout } else if (viewType == 2) { k = R.layout.skill_layout } else if (viewType == 3) { k = R.layout.filter_layout }
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(k, parent, false)
        )
    }

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (items[position] is Profile) {
            val k = items[position] as Profile
            holder.onBindProfile(k.name, k.imageRes, k.github)
        } else if (items[position] is Text) {
            val k = items[position] as Text
            holder.onBindText(k.title, k.description)
        } else if (items[position] is Skill) {
            val k = items[position] as Skill
            holder.onBindSkill(k.title, k.longevity)
        } else if (items[position] is Filter) {
            val k = items[position] as Filter
            holder.onBindTitle(k.title, true)
            val ib1 = holder.ib1
            ib1.setOnClickListener(){
                val intent = Intent(mContext, MainActivity2::class.java)
                if (mContext != null) {
                    mContext!!.startActivity(intent)
                };
            }
        }
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        private val fio = root.tv; val textView = root.tv6; val ib1 = root.ib1; val face = root.img ; val git = root.button; val head = root.tv1; val cont = root.tv2; val tit = root.tv3; val long = root.tv4; val titl = root.tv5

        init {
        }

        fun onBindProfile(name: String, imageRes: Int,  github: String) {
            try {
                fio.text = name
                face.setImageResource(imageRes)
                git.setOnClickListener { git.text = github }
            } catch (e: Exception) {}
        }

        fun onBindText(title: String, description: String) {
            try {
                head.text = title
                cont.text = description
            } catch (e: Exception) {}
        }

        fun onBindSkill(title: String, longevity: Int) {
            try {
                tit.text = title
                long.text = longevity.toString()
            } catch (e: java.lang.Exception) {}
        }
        fun onBindTitle(title: String, all: Boolean) {
            try {
                titl.text = title
                if (all==true){
                    ib1.setImageResource(R.drawable.filter)
                } else {}
            } catch (e: java.lang.Exception) {}
        }

    }

    open fun onBindViewHolder(holder: FilterAdapter.ViewHolder, position: Int) {}
}
