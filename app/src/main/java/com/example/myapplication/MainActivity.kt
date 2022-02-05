package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
val  members=prepareMember()
        refreshAdapter(members)
    }

    fun initViews(){
        val manager = applicationContext.getSystemService(Context.TELEPHONY_SERVICE)as TelephonyManager
        if (Objects.requireNonNull(manager).phoneType == TelephonyManager.PHONE_TYPE_NONE){
            recycler_advents.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        }else{
            recycler_advents.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }
    fun prepareMember(): ArrayList<Member>{
        var members = ArrayList<Member>()
        for (i in 0..10){
            members.add(Member("Elektrik", R.drawable.img_2))
            members.add(Member("Fitnis", R.drawable.img_5))
            members.add(Member("Car washing", R.drawable.img_6))
            members.add(Member("Kiyimlar", R.drawable.img_7))
            members.add(Member("Telefonlar", R.drawable.img_8))
        }
        return members
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val adapter = Adapter_recycler(members)
        recycler_advents.adapter = adapter
    }

}