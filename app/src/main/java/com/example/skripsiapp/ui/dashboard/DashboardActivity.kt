package com.example.skripsiapp.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.example.skripsiapp.R
import com.example.skripsiapp.databinding.ActivityDashboardBinding
import com.example.skripsiapp.domain.adapter.UserUnivPagerAdapter
import com.example.skripsiapp.utils.SharedPreferencesHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }
    private val dashboardViewModel by viewModels<DashboardViewModel>()
    private val sharedPreferences by lazy { SharedPreferencesHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = sharedPreferences.prefNama.toString()

        init()
    }

    private fun init(){
        val sectionsPagerAdapter = UserUnivPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { dashboardViewModel.setPage(it) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("TabSelected", tab?.position.toString())
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("TabSelected", tab?.position.toString())
            }
        })
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_univ_upnvj,
            R.string.tab_univ_unj,
            R.string.tab_univ_uinj
        )
    }


}