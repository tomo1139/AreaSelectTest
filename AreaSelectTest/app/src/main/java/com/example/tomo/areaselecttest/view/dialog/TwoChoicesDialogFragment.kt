package com.example.tomo.areaselecttest.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import com.example.tomo.areaselecttest.extension.nonNullArguments

class TwoChoicesDialogFragment : DialogFragment() {

    private val title: String by lazy { nonNullArguments.getString(keyTitle) }
    private val message: String by lazy { nonNullArguments.getString(keyMessage) }
    private val positiveTitle: String by lazy { nonNullArguments.getString(keyPositiveTitle) }
    private val negativeTitle: String by lazy { nonNullArguments.getString(keyNegativeTitle) }
    private val requestCode: Int by lazy { nonNullArguments.getInt(keyRequestCode) }
    private val requestKey: String by lazy { nonNullArguments.getString(keyRequestKey) }
    private val requestParameter: Bundle? by lazy { nonNullArguments.getBundle(keyRequestParameter) }
    private var delegate: Delegate? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is Delegate) {
            delegate = context
        }

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = createListener()

        return AlertDialog.Builder(activity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveTitle, listener)
            .setNegativeButton(negativeTitle, listener)
            .create()
    }

    private fun createListener() = DialogInterface.OnClickListener { _, which ->
        targetFragment?.onActivityResult(targetRequestCode, which, requestParameter?.let { Intent().putExtra(requestKey, requestParameter) })
        delegate?.onClickButton(requestCode, which)
        dismiss()
    }

    companion object {
        private const val keyTitle = "keyTitle"
        private const val keyMessage = "keyMessage"
        private const val keyPositiveTitle = "keyPositiveTitle"
        private const val keyNegativeTitle = "keyNegativeTitle"
        private const val keyRequestCode = "keyRequestCode"
        private const val keyRequestKey = "keyRequestKey"
        private const val keyRequestParameter = "keyRequestParameter"

        fun newInstance(title: String, message: String, positiveTitle: String, negativeTitle: String, requestCode: Int, targetFragment: Fragment? = null, requestParameters: Pair<String, Bundle>? = null): TwoChoicesDialogFragment {
            val bundle = Bundle().also {
                it.putString(keyTitle, title)
                it.putString(keyMessage, message)
                it.putString(keyPositiveTitle, positiveTitle)
                it.putString(keyNegativeTitle, negativeTitle)
                it.putInt(keyRequestCode, requestCode)
                requestParameters?.let { param ->
                    it.putString(keyRequestKey, param.first)
                    it.putBundle(keyRequestParameter, param.second)
                }
            }
            val dialogFragment = TwoChoicesDialogFragment().also {
                it.arguments = bundle
                it.setTargetFragment(targetFragment, requestCode)
            }
            return dialogFragment
        }
    }

    interface Delegate {
        fun onClickButton(requestCode: Int, responseCode: Int)
    }
}
