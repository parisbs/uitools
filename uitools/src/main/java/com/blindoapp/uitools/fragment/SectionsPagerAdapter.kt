package com.blindoapp.uitools.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Tabs pager adapter for TabsView
 *
 * Create a tab pager adapter to use with TabsView with simple implementation ready to use, Inherits from FragmentPagerAdapter
 *
 * @property context the context to use with this adapter
 * @property numberOfTabs the number of tabs for this adapter (no mutable)
 * @param fragmentManager the fragment manager to use with this adapter
 * @constructor Creates a new pager adapter redy to use
 */
abstract class SectionsPagerAdapter(
    private val context: Context,
    private val numberOfTabs: Int,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    /**
     * Resolve the Fragment resource
     *
     * Determine the Fragment for the specific position of the adapter
     *
     * @param position the current adapter position
     * @return Fragment the Fragment resource
     */
    abstract fun fragmentResolver(position: Int): Fragment

    /**
     * Resolve the title resource
     *
     * Determine the title resource ID for the current position of the adapter
     *
     * @param position the current position
     * @return Int the string resource ID for the tab title
     */
    abstract fun titleResourceIdResolver(position: Int): Int

    override fun getItem(position: Int): Fragment = fragmentResolver(position)

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(
        titleResourceIdResolver(position)
    )

    override fun getCount(): Int = numberOfTabs
}
