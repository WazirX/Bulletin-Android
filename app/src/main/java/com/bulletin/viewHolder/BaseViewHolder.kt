package com.bulletin.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.app.BitRabbit.Classes.Components.FormCollection.FormRecyclerViewAdapter
import com.bulletin.models.BulletinItem


abstract class BaseViewHolder<T : BulletinItem>(
    VB: ViewBinding,
    listener: FormRecyclerViewAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(VB.root) {

    var _listener: FormRecyclerViewAdapter.OnItemClickListener? = null

    /** The view binding instance. */
    protected var _binding: ViewBinding? = null
    protected var topCellSeparatorView: View? = null
    protected var bottomCellSeparatorView: View? = null
    protected var bgView: View? = null
    lateinit var baseItem: T

    init {
        _listener = listener
        _binding = VB
    }

    // MARK: - Override Methods
    open fun updateAppearance() {

    }

    // region Abstract Method
    open fun bind(item: T) {
        baseItem = item
        updateAppearance()
    }

    abstract fun getBackgroundView(): View?
    // endregion
}
