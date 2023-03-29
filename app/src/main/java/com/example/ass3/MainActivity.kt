package com.example.ass3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ass3.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        analytics = Firebase.analytics
        binding.button.setOnClickListener { selectContent("123","Hello","ooo") }
        binding.button2.setOnClickListener { track() }

    }
    fun  selectContent(Id:String,Name:String,Type:String){
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){

            param(FirebaseAnalytics.Param.ITEM_ID,Id)
            param(FirebaseAnalytics.Param.ITEM_NAME,Name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE,Type)
        }
    }
    fun  track(){
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){

            param(FirebaseAnalytics.Param.SCREEN_NAME,"main")
            param(FirebaseAnalytics.Param.SCREEN_CLASS,"MainActivity")
        }
    }
}
