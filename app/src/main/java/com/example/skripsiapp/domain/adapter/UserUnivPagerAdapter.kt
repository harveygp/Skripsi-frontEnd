package com.example.skripsiapp.domain.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.skripsiapp.ui.dashboard.DashboardFragment

class UserUnivPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = DashboardFragment()
        fragment.arguments = Bundle().apply {
            putInt(DashboardFragment.ARG_SECTION_NUMBER, position + 1)
        }
        return fragment
    }
}