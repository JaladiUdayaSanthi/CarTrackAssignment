package com.demo.cartrack.extension

import android.content.Context
import android.widget.ArrayAdapter
import android.R
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged

fun Context.generateDataAdapter(arrayData: List<Any>): ArrayAdapter<Any> {
    val dataAdapter: ArrayAdapter<Any> = ArrayAdapter(
        this,
        R.layout.simple_spinner_item,
        arrayData)
    dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
    return dataAdapter
}

fun TextView.onClick(cb: (View) -> Unit) {
    this.setOnClickListener { cb(it) }
}

fun Button.onClick(cb: (View) -> Unit) {
    this.setOnClickListener { cb(it) }
}

fun TextView.onChange(cb: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            cb(s.toString())
        }
    })
}