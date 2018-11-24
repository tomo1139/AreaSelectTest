package com.example.tomo.areaselecttest.extension

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

val Fragment.nonNullContext: Context get() = context!!

val Fragment.nonNullActivity: FragmentActivity get() = activity!!

val Fragment.nonNullParentFragment: Fragment get() = parentFragment!!

val Fragment.nonNullFragmentManager: FragmentManager get() = fragmentManager!!

val Fragment.nonNullArguments: Bundle get() = arguments!!

val Fragment.appCompatActivity: AppCompatActivity get() = activity as AppCompatActivity
