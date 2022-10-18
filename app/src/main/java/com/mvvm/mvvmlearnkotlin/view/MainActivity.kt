package com.mvvm.mvvmlearnkotlin.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvm.mvvmlearnkotlin.R
import com.mvvm.mvvmlearnkotlin.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

       // setupObserver()



        btnClick.setOnClickListener {

        }
    }


//    private fun setupObserver() {
//        mainActivityViewModel.getUser()
//        mainActivityViewModel.servicesLiveData.observe(this, Observer { serviceSetterGetter ->
//
//            //val msg = serviceSetterGetter?.medium
//          //  Log.e("msg", "onCreate: "+msg )
//
//        })
//    }
}