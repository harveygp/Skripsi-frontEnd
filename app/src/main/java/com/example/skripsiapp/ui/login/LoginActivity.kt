package com.example.skripsiapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.skripsiapp.R
import com.example.skripsiapp.databinding.ActivityLoginBinding
import com.example.skripsiapp.ui.dashboard.DashboardActivity
import com.example.skripsiapp.utils.SharedPreferencesHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val sharedPreferences by lazy { SharedPreferencesHelper(this) }
    private val loginViewModel  by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        val items = listOf("IPA", "IPS")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        ( binding.edtDropdownInputRole as? AutoCompleteTextView)?.setAdapter(adapter)

        loginViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        loginViewModel.isSuccess.observe(this) {
            checkUserExist(it)
        }

        with(binding){

            btnMasuk.setOnClickListener {
                if(checkValue(edtName.text.toString(), edtDropdownInputRole.text.toString())){
                    loginViewModel.getStudentData(edtName.text.toString().uppercase(),edtDropdownInputRole.text.toString().uppercase())
                }
                else{
                    Toast.makeText(this@LoginActivity,"Masukan Semua Data Terlebih Dahulu",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun checkValue(nama : String, peminatan : String) : Boolean{
        return nama.isNotBlank() && peminatan.isNotBlank()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun checkUserExist(result : Boolean){
        if(result){
            sharedPreferences.prefNama = binding.edtName.text.toString().uppercase()
            sharedPreferences.prefPeminatan = binding.edtDropdownInputRole.text.toString().uppercase()
            val intentToDash = Intent(this@LoginActivity, DashboardActivity::class.java)
            intentToDash.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentToDash)
        }
        else{
            Toast.makeText(this@LoginActivity,"Tidak ditemukan data pelajar",Toast.LENGTH_SHORT).show()
        }
    }
}