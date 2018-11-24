package com.example.tomo.areaselecttest.extension

import android.content.Context
import android.widget.Toast
import com.example.tomo.areaselecttest.util.SingleSlotToasterHolder

fun Context.showLongToast(text: String) = SingleSlotToasterHolder.singleSlotToaster.showToast(this, text, Toast.LENGTH_LONG)

fun Context.showShortToast(text: String) = SingleSlotToasterHolder.singleSlotToaster.showToast(this, text, Toast.LENGTH_SHORT)

