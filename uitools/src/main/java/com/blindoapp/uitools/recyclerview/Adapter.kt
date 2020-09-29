package com.blindoapp.uitools.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for RecyclerViews
 *
 * Adapter for use with any RecyclerView with basic implementation ready
 *
 * @param T the type of object for this adapter
 * @property items the items that this adapter contains
 */
abstract class Adapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<T> = emptyList<T>().toMutableList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    /**
     * Append items
     *
     * Add new items at the end of the current items list and notify for changes automaticaly
     *
     * @param items the items list to add
     */
    fun appendItems(items: List<T>) {
        val initialSize = this.items.size
        this.items.addAll(items)
        notifyItemRangeChanged(initialSize, this.items.size)
    }

    /**
     * Clear items
     *
     * Clear the items list and notify changes automaticaly
     */
    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    /**
     * Bind items
     *
     * Bind the items on the ViewHolder of this adapter.
     * Use viewHolder param to access to itemView and
     * the item param to access to the object properties.
     * Requires to override getItemType method to work
     *
     * @param item the object to bind
     * @param viewHolder the view holder for bind
     */
    abstract fun bind(item: T, viewHolder: ViewHolder)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        bind(
            this.items[position],
            holder as ViewHolder
        )

    override fun getItemCount(): Int =
        this.items.count()
}
