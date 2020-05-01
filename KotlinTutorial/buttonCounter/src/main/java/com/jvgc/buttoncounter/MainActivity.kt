package com.jvgc.buttoncounter

import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.jvgc.lib.Constants
import com.jvgc.lib.activity.BaseActivity

class MainActivity : BaseActivity() {

    private val TAG = Constants.LOG_BUTTON_COUNTER

    companion object {
        const val TEXT_VIEW = "text_view"
    }

    private var mEditText: EditText? = null
    private var mButton: Button? = null
    private var mTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditText = findViewById(R.id.editText)
        mButton = findViewById(R.id.button)
        mTextView = findViewById(R.id.textView)
        mTextView?.movementMethod = ScrollingMovementMethod()

        mButton?.setOnClickListener {
            if (!TextUtils.isEmpty(mEditText?.text)) {
                mTextView?.append("${mEditText?.text}\n")
            }
            mEditText?.text?.clear()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        mTextView?.text = savedInstanceState?.getString(TEXT_VIEW)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putString(TEXT_VIEW, mTextView?.text.toString())
    }
}
