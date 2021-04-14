package com.demo.cartrack.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.demo.cartrack.R
import com.demo.cartrack.extension.generateDataAdapter
import com.demo.cartrack.utils.LoginUtils
import kotlinx.android.synthetic.main.component_country_picker.view.*

class CountryPickerComponent(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    lateinit var countryList: List<String>

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.component_country_picker, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        if (!isInEditMode) {
            countryList = LoginUtils.getCountryList()
            spCountryPicker.adapter = context.generateDataAdapter(countryList)
        }
    }

}