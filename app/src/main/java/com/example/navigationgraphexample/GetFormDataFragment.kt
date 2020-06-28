package com.example.navigationgraphexample

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView

class GetFormDataFragment : Fragment(R.layout.fragment_get_form_data) {

    private lateinit var mTextViewShowData: TextView
    private lateinit var name: String
    private lateinit var mobile: String
    private lateinit var location: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTextViewShowData = view.findViewById(R.id.textViewShowData)

        if (arguments != null) {
            val args: GetFormDataFragmentArgs =
                GetFormDataFragmentArgs.fromBundle(arguments as Bundle)
            name = args.name
            mobile = args.mobile
            location = args.location
        } else {
            name = "Dainavi"
            mobile = "9619380028"
            location = "Mumbai"
        }

        mTextViewShowData.text = getString(
            R.string.details,
            name,
            mobile,
            location
        )
    }

}
