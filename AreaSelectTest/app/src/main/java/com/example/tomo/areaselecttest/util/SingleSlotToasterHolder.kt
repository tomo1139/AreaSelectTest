package com.example.tomo.areaselecttest.util

import android.content.Context
import android.widget.Toast

object SingleSlotToasterHolder {
    val singleSlotToaster: SingleSlotToaster by lazy { SingleSlotToaster() }
}

class SingleSlotToaster {
    private var toast: Toast? = null

    fun showToast(context: Context, text: String, length: Int) {
        toast?.cancel()
        toast = Toast.makeText(context, text, length)
        toast?.show()
    }
}
