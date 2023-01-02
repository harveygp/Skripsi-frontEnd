package com.example.skripsiapp.ui.dashboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skripsiapp.adapter.ScoreResponseAdapter
import com.example.skripsiapp.data.remote.response.DataResponse
import com.example.skripsiapp.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val dashboardViewModel: DashboardViewModel by activityViewModels()
    private lateinit var recycleUser: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("tabs : ","this is tab ${ arguments?.getInt(ARG_SECTION_NUMBER, 0)}")

        recycleUser = binding.rvUser
        recycleUser.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(requireContext())
        recycleUser.layoutManager = layoutManager

        dashboardViewModel.pageNumber.observe(viewLifecycleOwner){
            showData("AERO CAKRA FADLULLAH",true, it)
        }

        dashboardViewModel.data.observe(viewLifecycleOwner) {
            setListData(it)
        }

        dashboardViewModel.isLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showData(nama : String,peminatan : Boolean,universtias : Int = 1){
        dashboardViewModel.getUserData(nama,peminatan,universtias)
    }

    private fun setListData(data : DataResponse){
        val adapter = ScoreResponseAdapter(data)
        binding.rvUser.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}