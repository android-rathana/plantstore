package com.rathanavoy.plantstore.util

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.rathanavoy.plantstore.util.extension.getDimen

class ListItemDecoration(
    private val context: Context,
    private val mode: DecoratedMode = DecoratedMode.MARGIN,
    @DimenRes private val left: Int? = null,
    @DimenRes private val top: Int? = null,
    @DimenRes private val right: Int? = null,
    @DimenRes private val bottom: Int? = null,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        when (mode) {
            DecoratedMode.MARGIN -> {
                left?.run {
                    outRect.left = context.getDimen(this)
                }
                top?.run {
                    outRect.top = context.getDimen(this)
                }
                right?.run {
                    outRect.right = context.getDimen(this)
                }
                bottom?.run {
                    outRect.bottom = context.getDimen(this)
                }
            }
            DecoratedMode.PADDING -> {
                view.setPadding(
                    left?.run { context.getDimen(this) } ?: view.paddingLeft,
                    top?.run { context.getDimen(this) } ?: view.paddingTop,
                    right?.run { context.getDimen(this) } ?: view.paddingRight,
                    bottom?.run { context.getDimen(this) } ?: view.paddingBottom
                )
            }
        }
    }

    enum class DecoratedMode { PADDING, MARGIN }

}
