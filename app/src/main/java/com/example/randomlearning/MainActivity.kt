package com.example.randomlearning

import android.content.res.TypedArray
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi

fun print(any: Any) = Log.v("Testy", any.toString())

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_layout)
        //if(R.bool.niewiem)
        if (getDrawable(R.drawable.person) == getDrawable(R.drawable.person_pl)) {
            print("Persony są te same! Użyto aliasu")
        }
        //<-- Look at colors on the left!
        R.color.colorPrimary
        R.color.alias

        if (!resources.getBoolean(R.bool.niewiem)) print("Już wiem!")

        val array: TypedArray = resources.obtainTypedArray(R.array.random_array)
        array.recycle()

    }
}
