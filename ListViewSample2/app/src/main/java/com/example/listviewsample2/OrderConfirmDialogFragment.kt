package com.example.listviewsample2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast

class OrderConfirmDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity).apply {
            setTitle(R.string.dialog_title)
            setMessage(R.string.dialog_msg)
            setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
            setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener())
            setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickListener())
        }

        return builder.create()
    }

    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {

        override fun onClick(dialog: DialogInterface?, which: Int) {
            val msg = when (which) {
                DialogInterface.BUTTON_POSITIVE -> getString(R.string.dialog_ok_toast)
                DialogInterface.BUTTON_NEGATIVE -> getString(R.string.dialog_ng_toast)
                DialogInterface.BUTTON_NEUTRAL -> getString(R.string.dialog_nu_toast)
                else -> ""
            }

            // activity は OrderConfirmDialogFragment の呼び出し元オブジェクト
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}
