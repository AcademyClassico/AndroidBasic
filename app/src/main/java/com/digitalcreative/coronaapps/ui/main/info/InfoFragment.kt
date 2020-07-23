package com.digitalcreative.coronaapps.ui.main.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.digitalcreative.coronaapps.R
import com.digitalcreative.coronaapps.adapter.InformationAdapter
import com.digitalcreative.coronaapps.data.model.Information
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : Fragment() {
    private val informationAdapter = InformationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val information = listOf(
            Information(
                "Apa itu virus corona?",
                """
                    Penyakit virus corona (COVID-19) adalah penyakit menular yang disebabkan oleh virus corona yang baru-baru ini ditemukan.
                    
                    Sebagian besar orang yang tertular COVID-19 akan mengalami gejala ringan hingga sedang dan akan pulih tanpa penanganan khusus.
                """.trimIndent()
            ),
            Information(
                "Bagaimana virus ini tersebar?",
                """
Virus yang menyebabkan COVID-19 terutama ditransmisikan melalui droplet (tetesan kecil) yang dihasilkan saat orang yang terinfeksi batuk, bersin, atau mengembuskan nafas. Droplet ini terlalu berat sehingga tidak bisa bertahan di udara. Droplet dengan cepat jatuh dan menempel pada lantai atau permukaan lainnya.
                    
Anda dapat tertular saat menghirup udara yang mengandung virus ketika Anda berada terlalu dekat dengan orang yang sudah terinfeksi COVID-19. Anda juga dapat tertular saat menyentuh permukaan benda yang terkontaminasi lalu menyentuh mata, hidung, atau mulut Anda.
                """.trimIndent()
            ),
            Information(
                "Siapa yang rentan terkena virus corona?",
                """
Tidak ada batasan usia orang-orang dapat terinfeksi oleh coronavirus ini (2019-nCoV). Namun orang yang lebih tua, dan orang-orang dengan kondisi medis yang sudah ada sebelumnya (seperti asma, diabetes, penyakit jantung) tampaknya lebih rentan untuk menderita sakit parah.
                """.trimIndent()
            )
        )
        informationAdapter.information = information

        rv_information.apply {
            adapter = informationAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }
}