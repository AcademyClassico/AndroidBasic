package com.digitalcreative.coronaapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.digitalcreative.coronaapps.diffutil.DistrictsDiffUtil
import com.digitalcreative.coronaapps.R
import com.digitalcreative.coronaapps.data.model.District
import com.digitalcreative.coronaapps.utils.AnimUtil.TYPE_COLLAPSE
import com.digitalcreative.coronaapps.utils.AnimUtil.TYPE_EXPAND
import com.digitalcreative.coronaapps.utils.AnimUtil.animateCollapse
import com.digitalcreative.coronaapps.utils.AnimUtil.animateExpand
import com.digitalcreative.coronaapps.utils.AnimUtil.animateRotate
import com.digitalcreative.coronaapps.utils.AnimUtil.isExpanded
import kotlinx.android.synthetic.main.item_district.view.*
import kotlinx.android.synthetic.main.item_statistic_counter.view.*


class DistrictAdapter : RecyclerView.Adapter<DistrictAdapter.ViewHolder>() {
    private val districts: MutableList<District> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_district, parent, false)
        )
    }

    override fun getItemCount(): Int = districts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val district = districts[position]
        holder.bind(district)
    }

    fun updateList(newList: List<District>) {
        val diff = DiffUtil.calculateDiff(
            DistrictsDiffUtil(
                districts,
                newList.toMutableList()
            )
        )
        districts.clear()
        districts.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(district: District) {
            with(itemView) {
                tv_district.text = district.name

                layout_positive.apply {
                    tv_statistic_number.apply {
                        text = district.positive.toString()
                        setTextColor(ContextCompat.getColor(context, R.color.colorPositive))
                    }

                    tv_statistic_text.apply {
                        text = context.getString(R.string.positive)
                        setTextColor(ContextCompat.getColor(context, R.color.colorPositive))
                    }
                }

                layout_recovered.apply {
                    tv_statistic_number.apply {
                        text = district.recovered.toString()
                        setTextColor(ContextCompat.getColor(context, R.color.colorRecovered))
                    }

                    tv_statistic_text.apply {
                        text = context.getString(R.string.recovered)
                        setTextColor(ContextCompat.getColor(context, R.color.colorRecovered))
                    }
                }

                layout_dead.apply {
                    tv_statistic_number.apply {
                        text = district.dead.toString()
                        setTextColor(ContextCompat.getColor(context, R.color.colorDead))
                    }

                    tv_statistic_text.apply {
                        text = context.getString(R.string.dead)
                        setTextColor(ContextCompat.getColor(context, R.color.colorDead))
                    }
                }

                card_view.setOnClickListener {
                    with(expand_layout) expand@{
                        if (isExpanded(this)) {
                            animateCollapse(this)
                            animateRotate(this@with.img_arrow, TYPE_COLLAPSE)
                        } else {
                            animateExpand(this)
                            animateRotate(this@with.img_arrow, TYPE_EXPAND)
                        }
                    }
                }
            }
        }
    }
}