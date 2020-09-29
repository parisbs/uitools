package com.blindoapp.uitoolssample.main

import com.blindoapp.uitools.recyclerview.Adapter
import com.blindoapp.uitools.recyclerview.ViewHolder
import com.blindoapp.uitoolssample.R
import kotlinx.android.synthetic.main.list_item_string.view.*

class MainAdapter : Adapter<String>() {

    override fun bind(item: String, viewHolder: ViewHolder) {
        viewHolder.itemView.apply {
            text.text = item
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.list_item_string
}
