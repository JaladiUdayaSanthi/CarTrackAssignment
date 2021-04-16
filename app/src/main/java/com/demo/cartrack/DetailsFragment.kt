package com.demo.cartrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.demo.cartrack.adapter.DetailsAdapter
import com.demo.cartrack.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created by JALADI UDAYA SANTHI on 09/04/2021
 */

class DetailsFragment : Fragment() {
    private val loginVieModel: LoginViewModel by sharedViewModel()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController().navigate(R.id.action_DetailsFragment_to_LoginFragment)
        }

        loginVieModel.getDetails({
           val adapter = it?.response?.let { it1 -> DetailsAdapter(it1) }
            rvList.adapter = adapter
        },{

        })
    }
}