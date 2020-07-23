package com.digitalcreative.coronaapps.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.digitalcreative.coronaapps.data.model.District

class DistrictsDiffUtil(
    private val oldList: MutableList<District>,
    private val newList: MutableList<District>
) :
    DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}