package com.demo.cartrack.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.demo.cartrack.MainActivity
import com.demo.cartrack.R
import com.demo.cartrack.extension.onChange
import com.demo.cartrack.extension.onClick
import com.demo.cartrack.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created by JALADI UDAYA SANTHI on 09/04/2021
 */

class LoginFragment : Fragment() {
    private lateinit var mActivity: MainActivity
    private val loginVieModel: LoginViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as MainActivity
        setValidators()
        btnClicks()

    }


    private fun setValidators() {
        editTextUserName.onChange {
            when {
                loginVieModel.validateUserName(it).first -> {
                    userNameLayout.error = ""
                }
                else -> {
                    userNameLayout.error = loginVieModel.validateUserName(it).second
                }
            }
        }

        editTextPassword.onChange {
            when {
                loginVieModel.validatePassword(it).first -> {
                    passwordLayout.error = ""
                }
                else -> {
                    passwordLayout.error = loginVieModel.validatePassword(it).second
                }
            }
        }
    }

    private fun btnClicks() {
        btnLogin.onClick {
            if(loginVieModel.checkUserDetails(editTextUserName.text.toString(), editTextPassword.text.toString()) == true)
                Toast.makeText(mActivity, "LOGIN DETAILS DOES NOT EXIST", Toast.LENGTH_SHORT).show()
            else
                findNavController().navigate(R.id.action_LoginFragment_to_DetailsFragment)

        }

        txtSignUP.onClick {
            findNavController().navigate(R.id.action_LoginFragment_to_SignUPFragment)
        }
    }
}