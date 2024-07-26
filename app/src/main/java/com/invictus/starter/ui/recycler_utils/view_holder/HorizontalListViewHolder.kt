package com.invictus.starter.ui.recycler_utils.view_holder

import androidx.core.util.TypedValueCompat.dpToPx
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.invictus.starter.domain.model.HorizontalListModel
import com.invictus.starter.ui.recycler_utils.RecyclerModel
import com.invictus.starter.ui.recycler_utils.adapter.MyRecycleAdapter

class HorizontalListViewHolder(private val recyclerView: RecyclerView) :
    BaseViewHolder<HorizontalListModel>(recyclerView) {
    private val adapter = MyRecycleAdapter()
    private val hDividerItemDecoration = MaterialDividerItemDecoration(
        recyclerView.context,
        LinearLayoutManager.HORIZONTAL,
    ).apply {
        dividerColor =
            recyclerView.context.getColor(android.R.color.transparent)
    }

    private val vDividerItemDecoration = MaterialDividerItemDecoration(
        recyclerView.context,
        LinearLayoutManager.VERTICAL,
    ).apply {
        dividerColor =
            recyclerView.context.getColor(android.R.color.transparent)
    }

    private val layoutManager = GridLayoutManager(
        recyclerView.context,
        1,
        LinearLayoutManager.HORIZONTAL,
        false
    )

    override fun bind(
        model: HorizontalListModel,
        onItemClickListener: ((RecyclerModel) -> Unit)?
    ) {

        layoutManager.spanCount = model.noOfRows
        adapter.setOnItemClickListener {
            onItemClickListener?.invoke(it)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        val hSpacing = dpToPx(
            model.horizontalGapDp,
            recyclerView.context.resources.displayMetrics
        ).toInt()
        val vSpacing = dpToPx(
            model.verticalGapDp,
            recyclerView.context.resources.displayMetrics
        ).toInt()


        if ((recyclerView.itemDecorationCount == 0)) {
            hDividerItemDecoration.dividerThickness = hSpacing
            vDividerItemDecoration.dividerThickness = vSpacing
            recyclerView.addItemDecoration(hDividerItemDecoration)
            recyclerView.addItemDecoration(vDividerItemDecoration)
        }
        recyclerView.setPadding(hSpacing, 0, 0, vSpacing)
        recyclerView.clipToPadding = false

        recyclerView.setHasFixedSize(true)
        adapter.submitList(model.recyclerModels)
    }

    override fun unbind() {
        recyclerView.adapter = null
        recyclerView.layoutManager = null
        adapter.setOnItemClickListener(null)
    }

}