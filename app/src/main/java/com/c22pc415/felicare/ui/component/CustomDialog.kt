package com.c22pc415.felicare.ui.component

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.c22pc415.felicare.R

object CustomDialog {
    private var dialog: Dialog? = null

    fun showLoading(activity: Activity){
        val dialogView = activity.layoutInflater.inflate(R.layout.layout_progress, null, false)

        dialog = Dialog(activity)
        dialog?.setCancelable(false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setContentView(dialogView)

        dialog?.show()
    }

    fun hideLoading(){
        dialog?.dismiss()
    }
}