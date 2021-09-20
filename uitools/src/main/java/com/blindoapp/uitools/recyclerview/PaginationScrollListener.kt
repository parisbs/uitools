package com.blindoapp.uitools.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Pagination scroll listener
 *
 * Scroll listener for manage RecyclerView pagination with basic implementation to load items at the end of the RecyclerView
 *
 * @param linearLayoutManager the LayoutManager to load the items (only support LinearLayoutManager)
 */
abstract class PaginationScrollListener(
    val linearLayoutManager: LinearLayoutManager
) : RecyclerView.OnScrollListener() {

    /**
     * Has next page
     *
     * If the adapter has next page of items
     *
     * @return Boolean
     */
    abstract fun hasNextPage(): Boolean

    /**
     * Prefetch Distance
     *
     * The distance to load more items
     *
     * @return Int
     */
    abstract fun prefetchDistance(): Int

    /**
     * Is loading
     *
     * If the adapter is currently loading more items
     *
     * @return Boolean
     */
    abstract fun isLoading(): Boolean

    /**
     * Load more items
     *
     * The implementation to load more items at the end of the adapter
     */
    abstract fun loadMoreItems()

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val totalItems = linearLayoutManager.itemCount
        val firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition()

        if (isLoading().not() && hasNextPage()) {
            if (firstVisiblePosition >= 0 && (firstVisiblePosition + prefetchDistance()) >= totalItems) {
                loadMoreItems()
            }
        }
    }
}
