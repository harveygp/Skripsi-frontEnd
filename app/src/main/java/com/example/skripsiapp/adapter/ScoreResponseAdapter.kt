package com.example.skripsiapp.adapter

import android.annotation.SuppressLint
import com.example.skripsiapp.data.remote.response.DataResponse
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.skripsiapp.databinding.UserItemRowBinding

class ScoreResponseAdapter (private val listResponseUser: DataResponse) : ListAdapter<DataResponse, ScoreResponseAdapter.ListViewHolder>(DIFF_CALLBACK) {

    class ListViewHolder(var binding : UserItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = UserItemRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (data,_) = listResponseUser
        holder.binding.tvMatakuliahUser.text = data[position].jurusan
        holder.binding.tvNilaiUser.text = data[position].nilai.toString()
    }

    override fun getItemCount(): Int = listResponseUser.matkul.size

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<DataResponse> =
            object : DiffUtil.ItemCallback<DataResponse>() {
                override fun areItemsTheSame(oldUser: DataResponse, newUser: DataResponse): Boolean {
                    return oldUser.matkul == newUser.matkul
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldUser: DataResponse, newUser: DataResponse): Boolean {
                    return oldUser == newUser
                }
            }
    }
}