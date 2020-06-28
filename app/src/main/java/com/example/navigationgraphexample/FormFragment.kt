package com.example.navigationgraphexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.navigationgraphexample.R.*
import com.example.navigationgraphexample.R.id.action_formFragment_to_getFormData
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * A simple [Fragment] subclass.
 */
class FormFragment : Fragment(layout.fragment_form), View.OnClickListener {

    private lateinit var mConstraintLayoutRegister: ConstraintLayout

    private lateinit var mTextViewRegisterMessageLabel: TextView
    private lateinit var mTextInputLayoutRegisterName: TextInputLayout

    private lateinit var mTextInputEditTextRegisterName: TextInputEditText
    private lateinit var mTextInputLayoutRegisterPhoneNumber: TextInputLayout

    private lateinit var mTextInputEditTextRegisterPhoneNumber: TextInputEditText
    private lateinit var mTextInputLayoutRegisterLocation: TextInputLayout

    private lateinit var mTextInputEditTextRegisterLocation: TextInputEditText

    private lateinit var mButtonRegisterLocateMe: Button

    private lateinit var mBundleRegister: Bundle

    private lateinit var mButtonRegisterSignUp: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mConstraintLayoutRegister = view.findViewById(R.id.constraintLayoutRegister)

        mTextViewRegisterMessageLabel = view.findViewById(R.id.textViewRegisterMessageLabel)

        mTextInputLayoutRegisterName = view.findViewById(R.id.textInputLayoutRegisterName)
        mTextInputEditTextRegisterName = view.findViewById(R.id.textInputEditTextRegisterName)

        mTextInputLayoutRegisterPhoneNumber =
            view.findViewById(R.id.textInputLayoutRegisterPhoneNumber)
        mTextInputEditTextRegisterPhoneNumber =
            view.findViewById(R.id.textInputEditTextRegisterPhoneNumber)

        mTextInputLayoutRegisterLocation = view.findViewById(R.id.textInputLayoutRegisterLocation)
        mTextInputEditTextRegisterLocation =
            view.findViewById(R.id.textInputEditTextRegisterLocation)

        mButtonRegisterSignUp = view.findViewById(R.id.buttonRegisterSignUp)
        mButtonRegisterSignUp.setOnClickListener(this@FormFragment)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonRegisterSignUp -> {
                isRegisterValidated()
            }
        }
    }

    private fun isRegisterValidated() {
        context?.let {
            if (mTextInputEditTextRegisterName.text?.isEmpty()!!) {
                mTextInputLayoutRegisterName.isErrorEnabled = true
                mTextInputLayoutRegisterName.error = "Can't Empty"
            } else if (mTextInputEditTextRegisterPhoneNumber.text?.isEmpty()!!) {
                mTextInputLayoutRegisterPhoneNumber.isErrorEnabled = true
                mTextInputLayoutRegisterPhoneNumber.error = "Can't Empty"
            } else if (mTextInputEditTextRegisterLocation.text?.isEmpty()!!) {
                mTextInputLayoutRegisterLocation.isErrorEnabled = true
                mTextInputLayoutRegisterLocation.error = "Can't Empty"
            } else {
                sendData()
            }
        }
    }

    fun sendData(){
        val action : FormFragmentDirections.ActionFormFragmentToGetFormData = FormFragmentDirections.actionFormFragmentToGetFormData()

        action.setName(mTextInputEditTextRegisterName.text.toString())
        action.setMobile(mTextInputEditTextRegisterPhoneNumber.text.toString())
        action.setLocation(mTextInputEditTextRegisterLocation.text.toString())

        view?.let { Navigation.findNavController(it).navigate(action) }

    }

}
