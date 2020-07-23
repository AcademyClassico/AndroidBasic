package com.digitalcreative.coronaapps.ui.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.digitalcreative.coronaapps.R
import com.digitalcreative.coronaapps.adapter.DistrictAdapter
import com.digitalcreative.coronaapps.adapter.DistrictPagingAdapter
import com.digitalcreative.coronaapps.data.model.TotalCovid
import com.digitalcreative.coronaapps.viewmodel.CovidViewModel
import com.digitalcreative.coronaapps.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.card_main_statistic.view.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_statistic_counter.view.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class ListFragment : Fragment() {
    private val districtAdapter = DistrictAdapter()
    private val districtAdapterPaging = DistrictPagingAdapter()
    private lateinit var viewModel: CovidViewModel
    private var job: Job? = null

    companion object {
        fun obtainViewModel(activity: FragmentActivity): CovidViewModel {
            val factory = ViewModelFactory.getInstance()
            return ViewModelProvider(activity, factory).get(CovidViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onPause() {
        super.onPause()
        job?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = obtainViewModel(requireActivity())
        setupRecyclerView()
        getTotalCovid()
        getCovidDataPaging()
    }

    private fun setupMainCard(data: TotalCovid) {
        card_main.apply {
            tv_last_updated.text = getString(R.string.last_updated, "16 Juli 2020")

            layout_positive.apply {
                tv_statistic_number.apply {
                    text = data.positive.toString()
                    setTextColor(ContextCompat.getColor(context, R.color.colorPositive))
                }

                tv_statistic_text.apply {
                    text = context.getString(R.string.positive)
                    setTextColor(ContextCompat.getColor(context, R.color.colorPositive))
                }
            }

            layout_recovered.apply {
                tv_statistic_number.apply {
                    text = data.recovered.toString()
                    setTextColor(ContextCompat.getColor(context, R.color.colorRecovered))
                }

                tv_statistic_text.apply {
                    text = context.getString(R.string.recovered)
                    setTextColor(ContextCompat.getColor(context, R.color.colorRecovered))
                }
            }

            layout_dead.apply {
                tv_statistic_number.apply {
                    text = data.dead.toString()
                    setTextColor(ContextCompat.getColor(context, R.color.colorDead))
                }

                tv_statistic_text.apply {
                    text = context.getString(R.string.dead)
                    setTextColor(ContextCompat.getColor(context, R.color.colorDead))
                }
            }
        }
    }

    private fun setupRecyclerView() {
        rv_kecamatan.apply {
            layoutManager = LinearLayoutManager(requireActivity())
//            adapter = districtAdapter
            adapter = districtAdapterPaging
        }
    }

//    private fun getCovidData() {
//        viewModel.covidData.observe(viewLifecycleOwner, Observer {
//            val dataDistricts = it.data.districts
//            val dataTotalCovid = it.data.totalCovid
//            setupMainCard(dataTotalCovid)
//            districtAdapter.updateList(dataDistricts)
//        })
//    }

    private fun getCovidDataPaging() {
        job = lifecycleScope.launch {
            viewModel.covidDataPaging.collect {
                districtAdapterPaging.submitData(it)
            }
        }
    }

    private fun getTotalCovid() {
        viewModel.totalCovid.observe(viewLifecycleOwner, Observer {
            setupMainCard(it.data)
        })
    }
}