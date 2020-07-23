package com.digitalcreative.coronaapps.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.digitalcreative.coronaapps.data.model.District

class DistrictSingleDiffUtil : DiffUtil.ItemCallback<District>() {
    override fun areItemsTheSame(oldItem: District, newItem: District): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: District, newItem: District): Boolean {
        return oldItem == newItem
    }
}