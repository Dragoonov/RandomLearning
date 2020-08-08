package com.example.randomlearning

import android.app.Activity
import android.util.Log
import java.lang.ref.WeakReference

object ReferenceHolder {
    var weakReferecne: MainActivity? = null
    var set: Boolean = false

    fun setReference(activity: MainActivity) {
        Log.v("Holder", "Setting reference")
        weakReferecne = activity
        set = true
    }

    fun printReferences(activity: Activity) {
        val weak = weakReferecne
        Log.v(activity::class.simpleName + "Holder",
            "Reference: $weak")
    }
}