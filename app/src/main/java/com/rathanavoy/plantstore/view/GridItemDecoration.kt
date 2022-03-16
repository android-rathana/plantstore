package com.rathanavoy.plantstore.view

import android.app.Activity
import android.graphics.Rect
import android.view.View
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.recyclerview.widget.RecyclerView
import com.rathanavoy.plantstore.util.extension.getScreenWidth

class GridItemDecoration(
    private val activity: Activity,
    private val column: Int,
    private val margin: Int
) :
    RecyclerView.ItemDecoration() {

    private var mNeedLeftSpacing = false

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val frameWidth =
            ((parent.width - margin.toFloat() * (column - 1)) / column).toInt()
        val padding = parent.width / column - frameWidth
        val itemSize = getItemSize(parent, view)
        val itemPosition = (view.layoutParams as RecyclerView.LayoutParams).run {
            width = itemSize
            viewAdapterPosition
        }
        if (itemPosition < column) {
            outRect.top = 0
        } else {
            outRect.top = margin
        }
        if (itemPosition % column == 0) {
            outRect.left = 0
            outRect.right = padding
            mNeedLeftSpacing = true
        } else if ((itemPosition + 1) % column == 0) {
            mNeedLeftSpacing = false
            outRect.right = 0
            outRect.left = padding
        } else if (mNeedLeftSpacing) {
            mNeedLeftSpacing = false
            outRect.left = margin - padding
            if ((itemPosition + 2) % column == 0) {
                outRect.right = margin - padding
            } else {
                outRect.right = margin / 2
            }
        } else if ((itemPosition + 2) % column == 0) {
            mNeedLeftSpacing = false
            outRect.left = margin / 2
            outRect.right = margin - padding
        } else {
            mNeedLeftSpacing = false
            outRect.left = margin / 2
            outRect.right = margin / 2
        }
        outRect.bottom = 0
    }

    private fun getItemSize(parent: RecyclerView, view: View): Int {
        return activity.getScreenWidth() / 2 + (margin * 2) -
                (view.marginStart +
                        view.marginEnd +
                        view.paddingStart +
                        view.paddingEnd +
                        parent.marginStart +
                        parent.marginEnd +
                        parent.paddingStart +
                        parent.paddingEnd)
    }
}