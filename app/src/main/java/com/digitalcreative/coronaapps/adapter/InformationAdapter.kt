package com.digitalcreative.coronaapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalcreative.coronaapps.R
import com.digitalcreative.coronaapps.data.model.Information
import com.digitalcreative.coronaapps.utils.AnimUtil
import kotlinx.android.synthetic.main.item_information.view.*
import kotlinx.android.synthetic.main.item_information.view.img_arrow

class InformationAdapter : RecyclerView.Adapter<InformationAdapter.ViewHolder>() {
    var information = listOf<Information>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_information, parent, false)
        )
    }

    override fun getItemCount(): Int = information.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = information[position]
        holder.bind(info)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(info: Information) {
            with(itemView) {
                tv_title.text = info.title
                tv_description.text = info.description

                card_view.setOnClickListener {
                    with(expand_layout) expand@{
                        if (AnimUtil.isExpanded(this)) {
                            AnimUtil.animateCollapse(this)
                            AnimUtil.animateRotate(this@with.img_arrow, AnimUtil.TYPE_COLLAPSE)
                        } else {
                            AnimUtil.animateExpand(this)
                            AnimUtil.animateRotate(this@with.img_arrow, AnimUtil.TYPE_EXPAND)
                        }
                    }
                }
            }
        }
    }
}