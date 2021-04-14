package com.demo.cartrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.demo.cartrack.extension.onChange
import com.demo.cartrack.extension.onClick
import com.demo.cartrack.viewmodel.LoginViewModel
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_signup.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
/**
 * Created by JALADI UDAYA SANTHI on 09/04/2021
 */

class SignUPFragment : Fragment() {
    private lateinit var mActivity: MainActivity
    private val loginVieModel: LoginViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as MainActivity
        setValidators()
        btnClick()
    }

    private fun setValidators() {
        createUserName.onChange {
            when {
                loginVieModel.validateUserName(it).first -> {
                    createUserNameLayout.error = ""
                }
                else -> {
                    createUserNameLayout.error = loginVieModel.validateUserName(it).second
                }
            }
        }

        createPassword.onChange {
            when {
                loginVieModel.validatePassword(it).first -> {
                    createPasswordLayout.error = ""
                }
                else -> {
                    createPasswordLayout.error = loginVieModel.validatePassword(it).second
                }
            }
        }
    }

    private fun btnClick() {
        btnSignup.onClick {
            if(loginVieModel.checkUserDetails(createUserName.text.toString(), createPassword.text.toString()).value == true)
                Toast.makeText(mActivity, "DETAILS ALREADY EXISTED", Toast.LENGTH_SHORT).show()
            else {
                if(loginVieModel.storeUserDetails(createUserName.toString(), createPassword.toString()).value == true)
                    Toast.makeText(mActivity, "DETAILS ARE STORED", Toast.LENGTH_SHORT).show()
            }

            findNavController().navigate(R.id.action_SignupFragment_to_LoginFragment)
        }
    }
}