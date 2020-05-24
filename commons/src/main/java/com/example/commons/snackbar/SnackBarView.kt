package com.example.commons.snackbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.example.commons.R
import kotlinx.android.synthetic.main.snackbar_view.view.*

class SnackBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var messange: String = "Messange !"

    init {
        initView()
    }

    private fun initView() {
        val view = View.inflate(context, R.layout.snackbar_view, null)
        view?.title?.text = messange
        addView(view)
    }

    companion object {
        private lateinit var snackBarView: SnackBarView

        @JvmStatic
        fun onCreate(context: Context): Companion {
            snackBarView = SnackBarView(context)
            return this
        }

        fun setMessage(message: String): Companion {
            snackBarView.messange = message
            return this
        }

        @JvmStatic
        fun build(): SnackBarView {
            return snackBarView
        }
    }
}