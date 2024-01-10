package com.example.bulbyandex.presenter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.bulbyandex.UiState

class StatusAdapter(private val context: Context, private var listColors: List<String>?) : BaseAdapter() {

    fun submitList(list: List<String>?) {
        listColors = list
        notifyDataSetChanged()
    }

    fun clearList() {
        listColors = emptyList()
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return listColors!!.size
    }

    override fun getItem(position: Int): String {
        return listColors!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = TextView(context)
        textView.text = listColors!![position]
        return textView
    }

    fun submitUiList(list: UiState<List<String>?>?) {
        when (list) {
            is UiState.Success -> {
                listColors = list.value
                notifyDataSetChanged()
            }

            else -> {}
        }
    }

}



