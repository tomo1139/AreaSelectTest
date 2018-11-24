package com.example.tomo.areaselecttest.extension

import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager

fun DialogFragment.showDialogWithAllowingStateLoss(manager: FragmentManager?, tag: String? = null) {
    manager?.beginTransaction()?.also {
        it.add(this, tag)
    }?.commitAllowingStateLoss()
}
