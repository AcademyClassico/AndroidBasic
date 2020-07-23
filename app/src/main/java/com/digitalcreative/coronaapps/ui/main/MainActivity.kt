package com.digitalcreative.coronaapps.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.digitalcreative.coronaapps.R
import com.digitalcreative.coronaapps.ui.main.info.InfoFragment
import com.digitalcreative.coronaapps.ui.main.list.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(ListFragment())

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_list -> {
                    loadFragment(ListFragment())
                    true
                }
                R.id.menu_info -> {
                    loadFragment(InfoFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val fragmentName = fragment.javaClass.simpleName

        if (manager.findFragmentByTag(fragmentName) == null) {
            transaction.replace(R.id.container, fragment, fragmentName)
            transaction.commit()
        }
    }
}